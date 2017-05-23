package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Mail_ReceiversProxi extends PersistentListProxi<AccountWrapper4Public> {

  	private AccountWrapperList list;
  	private Mail owner;

  	public Mail_ReceiversProxi(Mail owner) {
    	this.owner = owner;
  	}
  	public AccountWrapperList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AccountWrapperList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theMailFacade.receiversGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<AccountWrapper4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<AccountWrapper4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(AccountWrapper4Public entry) throws PersistenceException {
    	if (entry != null) {
      		AccountWrapperList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theMailFacade
        	               	.receiversAdd(owner.getId(), entry);
      		}
      		list.add((AccountWrapper4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theMailFacade.receiversRem(entry.getListEntryId());
    	}
    	
  	}
  	public Mail_ReceiversProxi copy(Mail owner) throws PersistenceException {
  		Mail_ReceiversProxi result = new Mail_ReceiversProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<AccountWrapper4Public> entries = (this.list == null ? new java.util.Vector<AccountWrapper4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			AccountWrapper4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theMailFacade
            	           .receiversAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
