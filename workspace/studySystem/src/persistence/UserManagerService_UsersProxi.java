package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class UserManagerService_UsersProxi extends PersistentListProxi<Server4Public> {

  	private ServerList list;
  	private UserManagerService owner;

  	public UserManagerService_UsersProxi(UserManagerService owner) {
    	this.owner = owner;
  	}
  	public ServerList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ServerList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theUserManagerServiceFacade.usersGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Server4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Server4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Server4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ServerList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
        	               	.usersAdd(owner.getId(), entry);
      		}
      		list.add((Server4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade.usersRem(entry.getListEntryId());
    	}
    	
  	}
  	public UserManagerService_UsersProxi copy(UserManagerService owner) throws PersistenceException {
  		UserManagerService_UsersProxi result = new UserManagerService_UsersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Server4Public> entries = (this.list == null ? new java.util.Vector<Server4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Server4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
            	           .usersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
