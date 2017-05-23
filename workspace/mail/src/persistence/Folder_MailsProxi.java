package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Folder_MailsProxi extends PersistentListProxi<Mail4Public> {

  	private MailList list;
  	private Folder owner;

  	public Folder_MailsProxi(Folder owner) {
    	this.owner = owner;
  	}
  	public MailList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new MailList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theFolderFacade.mailsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Mail4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Mail4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Mail4Public entry) throws PersistenceException {
    	if (entry != null) {
      		MailList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theFolderFacade
        	               	.mailsAdd(owner.getId(), entry);
      		}
      		list.add((Mail4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theFolderFacade.mailsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Folder_MailsProxi copy(Folder owner) throws PersistenceException {
  		Folder_MailsProxi result = new Folder_MailsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Mail4Public> entries = (this.list == null ? new java.util.Vector<Mail4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Mail4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theFolderFacade
            	           .mailsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
