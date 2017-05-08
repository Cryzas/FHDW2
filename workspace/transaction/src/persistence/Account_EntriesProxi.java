package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Account_EntriesProxi extends PersistentListProxi<Entry4Public> {

  	private EntryList list;
  	private Account owner;

  	public Account_EntriesProxi(Account owner) {
    	this.owner = owner;
  	}
  	public EntryList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new EntryList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountFacade.entriesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Entry4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Entry4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Entry4Public entry) throws PersistenceException {
    	if (entry != null) {
      		EntryList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
        	               	.entriesAdd(owner.getId(), entry);
      		}
      		list.add((Entry4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountFacade.entriesRem(entry.getListEntryId());
    	}
    	
  	}
  	public Account_EntriesProxi copy(Account owner) throws PersistenceException {
  		Account_EntriesProxi result = new Account_EntriesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Entry4Public> entries = (this.list == null ? new java.util.Vector<Entry4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Entry4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
            	           .entriesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
