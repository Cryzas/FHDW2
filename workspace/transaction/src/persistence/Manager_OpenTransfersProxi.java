package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Manager_OpenTransfersProxi extends PersistentListProxi<Transfer4Public> {

  	private TransferList list;
  	private Manager owner;

  	public Manager_OpenTransfersProxi(Manager owner) {
    	this.owner = owner;
  	}
  	public TransferList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new TransferList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theManagerFacade.openTransfersGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Transfer4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Transfer4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Transfer4Public entry) throws PersistenceException {
    	if (entry != null) {
      		TransferList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theManagerFacade
        	               	.openTransfersAdd(owner.getId(), entry);
      		}
      		list.add((Transfer4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theManagerFacade.openTransfersRem(entry.getListEntryId());
    	}
    	
  	}
  	public Manager_OpenTransfersProxi copy(Manager owner) throws PersistenceException {
  		Manager_OpenTransfersProxi result = new Manager_OpenTransfersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Transfer4Public> entries = (this.list == null ? new java.util.Vector<Transfer4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Transfer4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theManagerFacade
            	           .openTransfersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
