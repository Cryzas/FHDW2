package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Account_FoldersProxi extends PersistentListProxi<Folder4Public> {

  	private FolderList list;
  	private Account owner;

  	public Account_FoldersProxi(Account owner) {
    	this.owner = owner;
  	}
  	public FolderList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new FolderList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountFacade.foldersGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Folder4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Folder4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Folder4Public entry) throws PersistenceException {
    	if (entry != null) {
      		FolderList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
        	               	.foldersAdd(owner.getId(), entry);
      		}
      		list.add((Folder4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountFacade.foldersRem(entry.getListEntryId());
    	}
    	
  	}
  	public Account_FoldersProxi copy(Account owner) throws PersistenceException {
  		Account_FoldersProxi result = new Account_FoldersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Folder4Public> entries = (this.list == null ? new java.util.Vector<Folder4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Folder4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
            	           .foldersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
