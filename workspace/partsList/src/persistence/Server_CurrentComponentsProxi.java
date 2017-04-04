package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Server_CurrentComponentsProxi extends PersistentListProxi<Component4Public> {

  	private ComponentList list;
  	private Server owner;

  	public Server_CurrentComponentsProxi(Server owner) {
    	this.owner = owner;
  	}
  	public ComponentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ComponentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theServerFacade.currentComponentsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Component4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Component4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Component4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ComponentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theServerFacade
        	               	.currentComponentsAdd(owner.getId(), entry);
      		}
      		list.add((Component4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theServerFacade.currentComponentsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Server_CurrentComponentsProxi copy(Server owner) throws PersistenceException {
  		Server_CurrentComponentsProxi result = new Server_CurrentComponentsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Component4Public> entries = (this.list == null ? new java.util.Vector<Component4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Component4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theServerFacade
            	           .currentComponentsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
