package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class AccountManagerCurrentAccounts_ObserveeProxi extends PersistentListProxi<AccountHandle4Public> {

  	private AccountHandleList list;
  	private AccountManagerCurrentAccounts owner;

  	public AccountManagerCurrentAccounts_ObserveeProxi(AccountManagerCurrentAccounts owner) {
    	this.owner = owner;
  	}
  	public AccountHandleList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AccountHandleList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountManagerCurrentAccountsFacade.observeeGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((AccountHandle4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.observeeRem(entry.getListEntryId());
    	}
    	((AccountHandle4Public)entry).deregister(this.owner);
  	}
  	public AccountManagerCurrentAccounts_ObserveeProxi copy(AccountManagerCurrentAccounts owner) throws PersistenceException {
  		AccountManagerCurrentAccounts_ObserveeProxi result = new AccountManagerCurrentAccounts_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<AccountHandle4Public> entries = (this.list == null ? new java.util.Vector<AccountHandle4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			AccountHandle4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
