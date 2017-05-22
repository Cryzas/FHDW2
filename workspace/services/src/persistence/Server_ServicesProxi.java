package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Server_ServicesProxi extends PersistentListProxi<Service4Public> {

  	private ServiceList list;
  	private Server owner;

  	public Server_ServicesProxi(Server owner) {
    	this.owner = owner;
  	}
  	public ServiceList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ServiceList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theServerFacade.servicesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Service4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Service4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Service4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ServiceList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theServerFacade
        	               	.servicesAdd(owner.getId(), entry);
      		}
      		list.add((Service4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theServerFacade.servicesRem(entry.getListEntryId());
    	}
    	
  	}
  	public Server_ServicesProxi copy(Server owner) throws PersistenceException {
  		Server_ServicesProxi result = new Server_ServicesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Service4Public> entries = (this.list == null ? new java.util.Vector<Service4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Service4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theServerFacade
            	           .servicesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
