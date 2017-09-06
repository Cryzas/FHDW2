package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ProgramManager_ProgramsProxi extends PersistentListProxi<Program4Public> {

  	private ProgramList list;
  	private ProgramManager owner;

  	public ProgramManager_ProgramsProxi(ProgramManager owner) {
    	this.owner = owner;
  	}
  	public ProgramList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ProgramList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theProgramManagerFacade.programsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Program4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Program4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Program4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ProgramList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
        	               	.programsAdd(owner.getId(), entry);
      		}
      		list.add((Program4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.programsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ProgramManager_ProgramsProxi copy(ProgramManager owner) throws PersistenceException {
  		ProgramManager_ProgramsProxi result = new ProgramManager_ProgramsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Program4Public> entries = (this.list == null ? new java.util.Vector<Program4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Program4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
            	           .programsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
