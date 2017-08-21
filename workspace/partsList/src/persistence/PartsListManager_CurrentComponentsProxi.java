package persistence;

import model.*;
import java.util.Hashtable;

public class PartsListManager_CurrentComponentsProxi extends PersistentMapProxi<String,Component4Public>{

	private PartsListManager owner;

	private Hashtable<String, Component4Public> data;
	private boolean inSync;

	public PartsListManager_CurrentComponentsProxi(PartsListManager owner) {
		this.owner = owner;
		this.data = new Hashtable<String, Component4Public>();
		this.inSync = false;
	}

	public synchronized Component4Public put(String key, Component4Public entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		Component4Public result = null;
		
		if (!this.owner.isDelayed$Persistence()){
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsAdd(owner.getId(), key, entry);
			if (this.inSync){
				Component4Public mapEntry = this.get(key);
				this.data.put(key,mapEntry);
			} else {
				this.data.put(key,entry);
			}
		} else {
			result = this.data.put(key, entry);
		}
		
		return result;
	}

	public synchronized Component4Public get(String key) throws PersistenceException {
		Component4Public result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized Component4Public remove(String key) throws PersistenceException {
		
		Component4Public result = this.data.remove(key);
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsRem(this.owner.getId(), key);
		}
		return result;
	}
	protected void removeEntry(Component4Public entry) throws PersistenceException {
    	
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsRemEntr(((PersistentListEntryProxi)entry).getListEntryId());
    	}
  	}
	@SuppressWarnings("unchecked")
	public PartsListManager_CurrentComponentsProxi copy(PartsListManager owner) throws PersistenceException {
		PartsListManager_CurrentComponentsProxi result = new PartsListManager_CurrentComponentsProxi(owner);
		result.data = (Hashtable<String, Component4Public>) this.data.clone();
		return result;
	}
	
	public ComponentSearchList getValues() throws PersistenceException {
		if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
		ComponentSearchList result = new ComponentSearchList(); 
		if (this.owner.isDelayed$Persistence()){ 
			for (Component4Public current : this.data.values()) result.add(current);
		} else {
			java.util.TreeSet<PersistentListEntryProxi> sorter 
					= new java.util.TreeSet<PersistentListEntryProxi>(new java.util.Comparator<PersistentListEntryProxi>() {
				public int compare(PersistentListEntryProxi o1,PersistentListEntryProxi o2) {
					return new Long(o1.getListEntryId()).compareTo(o2.getListEntryId());
				}
			});
			for (Component4Public current : this.data.values()) sorter.add((PersistentListEntryProxi) current);
			for (PersistentListEntryProxi current : sorter) result.add((Component4Public) current);
		}
		return result;
	}
	private void synchroniseWithDatabase() throws PersistenceException {
		if(!this.inSync){
			this.data = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsGetValues(owner.getId());
			this.inSync = true;
		}
	}
	public java.util.Iterator<Component4Public> iterator() {
		try {
			if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
			return new PersistentMapIterator<String,Component4Public>(this, this.data);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public void store() throws PersistenceException {
		java.util.Iterator<String> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			String key = keys.next();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsAdd(owner.getId(), key, data.get(key));
		}
		this.synchroniseWithDatabase();
	}
}
