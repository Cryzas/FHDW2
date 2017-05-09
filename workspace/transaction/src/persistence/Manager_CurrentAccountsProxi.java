package persistence;

import model.*;
import java.util.Hashtable;

public class Manager_CurrentAccountsProxi extends PersistentMapProxi<String,Account4Public>{

	private Manager owner;

	private Hashtable<String, Account4Public> data;
	private boolean inSync;

	public Manager_CurrentAccountsProxi(Manager owner) {
		this.owner = owner;
		this.data = new Hashtable<String, Account4Public>();
		this.inSync = false;
	}

	public synchronized Account4Public put(String key, Account4Public entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		Account4Public result = null;
		
		if (!this.owner.isDelayed$Persistence()){
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsAdd(owner.getId(), key, entry);
			if (this.inSync){
				Account4Public mapEntry = this.get(key);
				this.data.put(key,mapEntry);
			} else {
				this.data.put(key,entry);
			}
		} else {
			result = this.data.put(key, entry);
		}
		
		return result;
	}

	public synchronized Account4Public get(String key) throws PersistenceException {
		Account4Public result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized Account4Public remove(String key) throws PersistenceException {
		
		Account4Public result = this.data.remove(key);
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsRem(this.owner.getId(), key);
		}
		return result;
	}
	protected void removeEntry(Account4Public entry) throws PersistenceException {
    	
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsRemEntr(((PersistentListEntryProxi)entry).getListEntryId());
    	}
  	}
	@SuppressWarnings("unchecked")
	public Manager_CurrentAccountsProxi copy(Manager owner) throws PersistenceException {
		Manager_CurrentAccountsProxi result = new Manager_CurrentAccountsProxi(owner);
		result.data = (Hashtable<String, Account4Public>) this.data.clone();
		return result;
	}
	
	public AccountSearchList getValues() throws PersistenceException {
		if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
		AccountSearchList result = new AccountSearchList(); 
		if (this.owner.isDelayed$Persistence()){ 
			for (Account4Public current : this.data.values()) result.add(current);
		} else {
			java.util.TreeSet<PersistentListEntryProxi> sorter 
					= new java.util.TreeSet<PersistentListEntryProxi>(new java.util.Comparator<PersistentListEntryProxi>() {
				public int compare(PersistentListEntryProxi o1,PersistentListEntryProxi o2) {
					return new Long(o1.getListEntryId()).compareTo(o2.getListEntryId());
				}
			});
			for (Account4Public current : this.data.values()) sorter.add((PersistentListEntryProxi) current);
			for (PersistentListEntryProxi current : sorter) result.add((Account4Public) current);
		}
		return result;
	}
	private void synchroniseWithDatabase() throws PersistenceException {
		if(!this.inSync){
			this.data = ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsGetValues(owner.getId());
			this.inSync = true;
		}
	}
	public java.util.Iterator<Account4Public> iterator() {
		try {
			if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
			return new PersistentMapIterator<String,Account4Public>(this, this.data);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public void store() throws PersistenceException {
		java.util.Iterator<String> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			String key = keys.next();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsAdd(owner.getId(), key, data.get(key));
		}
		this.synchroniseWithDatabase();
	}
}
