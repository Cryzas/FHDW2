package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Manager_CurrentAccountsProxi extends PersistentListProxi<Account4Public> {

  	private AccountList list;
  	private Manager owner;

  	public Manager_CurrentAccountsProxi(Manager owner) {
    	this.owner = owner;
  	}
  	public AccountList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AccountList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theManagerFacade.currentAccountsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Account4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Account4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Account4Public entry) throws PersistenceException {
    	if (entry != null) {
      		AccountList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theManagerFacade
        	               	.currentAccountsAdd(owner.getId(), entry);
      		}
      		list.add((Account4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theManagerFacade.currentAccountsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Manager_CurrentAccountsProxi copy(Manager owner) throws PersistenceException {
  		Manager_CurrentAccountsProxi result = new Manager_CurrentAccountsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Account4Public> entries = (this.list == null ? new java.util.Vector<Account4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Account4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theManagerFacade
            	           .currentAccountsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
