package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class TransferManager_TransfersProxi extends PersistentListProxi<Bookable4Public> {

  	private BookableList list;
  	private TransferManager owner;

  	public TransferManager_TransfersProxi(TransferManager owner) {
    	this.owner = owner;
  	}
  	public BookableList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new BookableList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theTransferManagerFacade.transfersGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Bookable4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Bookable4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Bookable4Public entry) throws PersistenceException {
    	if (entry != null) {
      		BookableList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
        	               	.transfersAdd(owner.getId(), entry);
      		}
      		list.add((Bookable4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.transfersRem(entry.getListEntryId());
    	}
    	
  	}
  	public TransferManager_TransfersProxi copy(TransferManager owner) throws PersistenceException {
  		TransferManager_TransfersProxi result = new TransferManager_TransfersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Bookable4Public> entries = (this.list == null ? new java.util.Vector<Bookable4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Bookable4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
            	           .transfersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
