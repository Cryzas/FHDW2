package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class WrapperRecycle_RecycledProxi extends PersistentListProxi<AccountWrppr4Public> {

  	private AccountWrpprList list;
  	private WrapperRecycle owner;

  	public WrapperRecycle_RecycledProxi(WrapperRecycle owner) {
    	this.owner = owner;
  	}
  	public AccountWrpprList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AccountWrpprList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theWrapperRecycleFacade.recycledGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<AccountWrppr4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<AccountWrppr4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(AccountWrppr4Public entry) throws PersistenceException {
    	if (entry != null) {
      		AccountWrpprList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theWrapperRecycleFacade
        	               	.recycledAdd(owner.getId(), entry);
      		}
      		list.add((AccountWrppr4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theWrapperRecycleFacade.recycledRem(entry.getListEntryId());
    	}
    	
  	}
  	public WrapperRecycle_RecycledProxi copy(WrapperRecycle owner) throws PersistenceException {
  		WrapperRecycle_RecycledProxi result = new WrapperRecycle_RecycledProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<AccountWrppr4Public> entries = (this.list == null ? new java.util.Vector<AccountWrppr4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			AccountWrppr4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theWrapperRecycleFacade
            	           .recycledAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
