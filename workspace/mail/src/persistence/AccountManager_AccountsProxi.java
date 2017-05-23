package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class AccountManager_AccountsProxi extends PersistentListProxi<Account4Public> {

  	private AccountList list;
  	private AccountManager owner;

  	public AccountManager_AccountsProxi(AccountManager owner) {
    	this.owner = owner;
  	}
  	public AccountList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AccountList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountManagerFacade.accountsGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
        	               	.accountsAdd(owner.getId(), entry);
      		}
      		list.add((Account4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.accountsRem(entry.getListEntryId());
    	}
    	
  	}
  	public AccountManager_AccountsProxi copy(AccountManager owner) throws PersistenceException {
  		AccountManager_AccountsProxi result = new AccountManager_AccountsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Account4Public> entries = (this.list == null ? new java.util.Vector<Account4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Account4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
            	           .accountsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
