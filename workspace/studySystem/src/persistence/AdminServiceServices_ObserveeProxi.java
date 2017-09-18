package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class AdminServiceServices_ObserveeProxi extends PersistentListProxi<subAdminService4Public> {

  	private subAdminServiceList list;
  	private AdminServiceServices owner;

  	public AdminServiceServices_ObserveeProxi(AdminServiceServices owner) {
    	this.owner = owner;
  	}
  	public subAdminServiceList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new subAdminServiceList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAdminServiceServicesFacade.observeeGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<subAdminService4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<subAdminService4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(subAdminService4Public entry) throws PersistenceException {
    	if (entry != null) {
      		subAdminServiceList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((subAdminService4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.observeeRem(entry.getListEntryId());
    	}
    	((subAdminService4Public)entry).deregister(this.owner);
  	}
  	public AdminServiceServices_ObserveeProxi copy(AdminServiceServices owner) throws PersistenceException {
  		AdminServiceServices_ObserveeProxi result = new AdminServiceServices_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<subAdminService4Public> entries = (this.list == null ? new java.util.Vector<subAdminService4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			subAdminService4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
