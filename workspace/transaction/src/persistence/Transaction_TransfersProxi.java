package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Transaction_TransfersProxi extends PersistentListProxi<Transfer4Public> {

  	private TransferList list;
  	private Transaction owner;

  	public Transaction_TransfersProxi(Transaction owner) {
    	this.owner = owner;
  	}
  	public TransferList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new TransferList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theTransactionFacade.transfersGet(this.owner.getId());
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
  	public void add(Transfer4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsbookableHierarchy(this.owner)) throw new model.CycleException("Cycle in bookableHierarchy detected!");
			TransferList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
        	               	.transfersAdd(owner.getId(), entry);
      		}
      		list.add((Transfer4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theTransactionFacade.transfersRem(entry.getListEntryId());
    	}
    	
  	}
  	public Transaction_TransfersProxi copy(Transaction owner) throws PersistenceException {
  		Transaction_TransfersProxi result = new Transaction_TransfersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Transfer4Public> entries = (this.list == null ? new java.util.Vector<Transfer4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Transfer4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
            	           .transfersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
