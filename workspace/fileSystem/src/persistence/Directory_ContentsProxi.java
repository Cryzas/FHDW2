package persistence;

import model.*;
import java.util.Hashtable;

public class Directory_ContentsProxi extends PersistentMapProxiWithCycleException<String,Containee4Public>{

	private Directory owner;

	private Hashtable<String, Containee4Public> data;
	private boolean inSync;

	public Directory_ContentsProxi(Directory owner) {
		this.owner = owner;
		this.data = new Hashtable<String, Containee4Public>();
		this.inSync = false;
	}

	public synchronized Containee4Public put(String key, Containee4Public entry) throws PersistenceException , model.CycleException{
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		Containee4Public result = null;
		
		if (entry.containsFileTree(this.owner)) throw new model.CycleException("Cycle in FileTree detected!");
		if (!this.owner.isDelayed$Persistence()){
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade.contentsAdd(owner.getId(), key, entry);
			if (this.inSync){
				Containee4Public mapEntry = this.get(key);
				this.data.put(key,mapEntry);
			} else {
				this.data.put(key,entry);
			}
		} else {
			result = this.data.put(key, entry);
		}
		
		return result;
	}

	public synchronized Containee4Public get(String key) throws PersistenceException {
		Containee4Public result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade.contentsGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized Containee4Public remove(String key) throws PersistenceException {
		
		Containee4Public result = this.data.remove(key);
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade.contentsRem(this.owner.getId(), key);
		}
		return result;
	}
	protected void removeEntry(Containee4Public entry) throws PersistenceException {
    	
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theDirectoryFacade.contentsRemEntr(((PersistentListEntryProxi)entry).getListEntryId());
    	}
  	}
	@SuppressWarnings("unchecked")
	public Directory_ContentsProxi copy(Directory owner) throws PersistenceException {
		Directory_ContentsProxi result = new Directory_ContentsProxi(owner);
		result.data = (Hashtable<String, Containee4Public>) this.data.clone();
		return result;
	}
	
	public ContaineeSearchList getValues() throws PersistenceException {
		if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
		ContaineeSearchList result = new ContaineeSearchList(); 
		if (this.owner.isDelayed$Persistence()){ 
			for (Containee4Public current : this.data.values()) result.add(current);
		} else {
			java.util.TreeSet<PersistentListEntryProxi> sorter 
					= new java.util.TreeSet<PersistentListEntryProxi>(new java.util.Comparator<PersistentListEntryProxi>() {
				public int compare(PersistentListEntryProxi o1,PersistentListEntryProxi o2) {
					return new Long(o1.getListEntryId()).compareTo(o2.getListEntryId());
				}
			});
			for (Containee4Public current : this.data.values()) sorter.add((PersistentListEntryProxi) current);
			for (PersistentListEntryProxi current : sorter) result.add((Containee4Public) current);
		}
		return result;
	}
	private void synchroniseWithDatabase() throws PersistenceException {
		if(!this.inSync){
			this.data = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade.contentsGetValues(owner.getId());
			this.inSync = true;
		}
	}
	public java.util.Iterator<Containee4Public> iterator() {
		try {
			if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
			return new PersistentMapIterator<String,Containee4Public>(this, this.data);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public void store() throws PersistenceException {
		java.util.Iterator<String> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			String key = keys.next();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theDirectoryFacade.contentsAdd(owner.getId(), key, data.get(key));
		}
		this.synchroniseWithDatabase();
	}
}
