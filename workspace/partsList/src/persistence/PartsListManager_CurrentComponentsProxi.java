package persistence;

import model.*;
import java.util.Hashtable;

public class PartsListManager_CurrentComponentsProxi implements PersistentMapProxi<String,Component4Public>{

	private PartsListManager owner;

	private Hashtable<String, Component4Public> data;
	private ComponentSearchList values;

	public PartsListManager_CurrentComponentsProxi(PartsListManager owner) {
		this.owner = owner;
		this.data = new Hashtable<String, Component4Public>();
	}

	public synchronized Component4Public put(String key, Component4Public entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		Component4Public result = null;
		
		if (!this.owner.isDelayed$Persistence()){
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsAdd(owner.getId(), key, entry);
		} else {
			result = this.data.get(key);
		}
		this.data.put(key, entry);
		this.values = null;
		
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
		this.values = null;
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsRem(this.owner.getId(), key);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public PartsListManager_CurrentComponentsProxi copy(PartsListManager owner) throws PersistenceException {
		PartsListManager_CurrentComponentsProxi result = new PartsListManager_CurrentComponentsProxi(owner);
		result.data = (Hashtable<String, Component4Public>) this.data.clone();
		return result;
	}
	
	public ComponentSearchList getValues() throws PersistenceException {
		if (this.values == null) {
			if (this.owner.isDelayed$Persistence()){
				this.values = new ComponentSearchList();
				for (Component4Public current : this.data.values()) {
					this.values.add(current);
				}
			} else {
				this.values = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsGetValues(owner.getId());
			}		
		}
		return this.values;
	}
	public void store() throws PersistenceException {
		java.util.Iterator<String> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			String key = keys.next();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.currentComponentsAdd(owner.getId(), key, data.get(key));
		}
	}
}
