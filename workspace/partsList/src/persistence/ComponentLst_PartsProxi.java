package persistence;

import model.*;
import java.util.Hashtable;

public class ComponentLst_PartsProxi extends PersistentMapProxi<Component4Public,QuantifiedComponent4Public>{

	private ComponentLst owner;

	private Hashtable<Component4Public, QuantifiedComponent4Public> data;
	private boolean inSync;

	public ComponentLst_PartsProxi(ComponentLst owner) {
		this.owner = owner;
		this.data = new Hashtable<Component4Public, QuantifiedComponent4Public>();
		this.inSync = false;
	}

	public synchronized QuantifiedComponent4Public put(Component4Public key, QuantifiedComponent4Public entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		QuantifiedComponent4Public result = null;
		
		if (!this.owner.isDelayed$Persistence()){
			key.store();
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsAdd(owner.getId(), key, entry);
			if (this.inSync){
				QuantifiedComponent4Public mapEntry = this.get(key);
				this.data.put(key,mapEntry);
			} else {
				this.data.put(key,entry);
			}
		} else {
			result = this.data.put(key, entry);
		}
		
		return result;
	}

	public synchronized QuantifiedComponent4Public get(Component4Public key) throws PersistenceException {
		QuantifiedComponent4Public result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized QuantifiedComponent4Public remove(Component4Public key) throws PersistenceException {
		
		QuantifiedComponent4Public result = this.data.remove(key);
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsRem(this.owner.getId(), key);
		}
		return result;
	}
	protected void removeEntry(QuantifiedComponent4Public entry) throws PersistenceException {
    	
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsRemEntr(((PersistentListEntryProxi)entry).getListEntryId());
    	}
  	}
	@SuppressWarnings("unchecked")
	public ComponentLst_PartsProxi copy(ComponentLst owner) throws PersistenceException {
		ComponentLst_PartsProxi result = new ComponentLst_PartsProxi(owner);
		result.data = (Hashtable<Component4Public, QuantifiedComponent4Public>) this.data.clone();
		return result;
	}
	
	public QuantifiedComponentSearchList getValues() throws PersistenceException {
		if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
		QuantifiedComponentSearchList result = new QuantifiedComponentSearchList(); 
		if (this.owner.isDelayed$Persistence()){ 
			for (QuantifiedComponent4Public current : this.data.values()) result.add(current);
		} else {
			java.util.TreeSet<PersistentListEntryProxi> sorter 
					= new java.util.TreeSet<PersistentListEntryProxi>(new java.util.Comparator<PersistentListEntryProxi>() {
				public int compare(PersistentListEntryProxi o1,PersistentListEntryProxi o2) {
					return new Long(o1.getListEntryId()).compareTo(o2.getListEntryId());
				}
			});
			for (QuantifiedComponent4Public current : this.data.values()) sorter.add((PersistentListEntryProxi) current);
			for (PersistentListEntryProxi current : sorter) result.add((QuantifiedComponent4Public) current);
		}
		return result;
	}
	private void synchroniseWithDatabase() throws PersistenceException {
		if(!this.inSync){
			this.data = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsGetValues(owner.getId());
			this.inSync = true;
		}
	}
	public java.util.Iterator<QuantifiedComponent4Public> iterator() {
		try {
			if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
			return new PersistentMapIterator<Component4Public,QuantifiedComponent4Public>(this, this.data);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public void store() throws PersistenceException {
		java.util.Iterator<Component4Public> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			Component4Public key = keys.next();
			key.store();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsAdd(owner.getId(), key, data.get(key));
		}
		this.synchroniseWithDatabase();
	}
}
