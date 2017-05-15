package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class AccountManager_CurrentAccountsProxi extends PersistentListProxi<AccountHandle4Public> {

  	private AccountHandleList list;
  	private AccountManager owner;

  	public AccountManager_CurrentAccountsProxi(AccountManager owner) {
    	this.owner = owner;
  	}
  	public AccountHandleList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AccountHandleList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountManagerFacade.currentAccountsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<AccountHandle4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<AccountHandle4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(AccountHandle4Public entry) throws PersistenceException {
    	if (entry != null) {
      		AccountHandleList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
        	               	.currentAccountsAdd(owner.getId(), entry);
      		}
      		list.add((AccountHandle4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.currentAccountsRem(entry.getListEntryId());
    	}
    	
  	}
  	public AccountManager_CurrentAccountsProxi copy(AccountManager owner) throws PersistenceException {
  		AccountManager_CurrentAccountsProxi result = new AccountManager_CurrentAccountsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<AccountHandle4Public> entries = (this.list == null ? new java.util.Vector<AccountHandle4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			AccountHandle4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
            	           .currentAccountsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
