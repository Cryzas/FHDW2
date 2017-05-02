package persistence;

import model.*;
import java.util.Hashtable;

public class ComponentLst_PartsProxi implements PersistentMapProxi<Component4Public,QuantifiedComponent4Public>{

	private ComponentLst owner;

	private Hashtable<Component4Public, QuantifiedComponent4Public> data;
	private QuantifiedComponentSearchList values;

	public ComponentLst_PartsProxi(ComponentLst owner) {
		this.owner = owner;
		this.data = new Hashtable<Component4Public, QuantifiedComponent4Public>();
	}

	public synchronized QuantifiedComponent4Public put(Component4Public key, QuantifiedComponent4Public entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		QuantifiedComponent4Public result = null;
		
		if (!this.owner.isDelayed$Persistence()){
			key.store();
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsAdd(owner.getId(), key, entry);
		} else {
			result = this.data.get(key);
		}
		this.data.put(key, entry);
		this.values = null;
		
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
		this.values = null;
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsRem(this.owner.getId(), key);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public ComponentLst_PartsProxi copy(ComponentLst owner) throws PersistenceException {
		ComponentLst_PartsProxi result = new ComponentLst_PartsProxi(owner);
		result.data = (Hashtable<Component4Public, QuantifiedComponent4Public>) this.data.clone();
		return result;
	}
	
	public QuantifiedComponentSearchList getValues() throws PersistenceException {
		if (this.values == null) {
			if (this.owner.isDelayed$Persistence()){
				this.values = new QuantifiedComponentSearchList();
				for (QuantifiedComponent4Public current : this.data.values()) {
					this.values.add(current);
				}
			} else {
				this.values = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsGetValues(owner.getId());
			}		
		}
		return this.values;
	}
	public void store() throws PersistenceException {
		java.util.Iterator<Component4Public> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			Component4Public key = keys.next();
			key.store();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsAdd(owner.getId(), key, data.get(key));
		}
	}
}
