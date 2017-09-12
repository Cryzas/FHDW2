package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Student_OldProgramsProxi extends PersistentListProxi<ProgramStudent4Public> {

  	private ProgramStudentList list;
  	private Student owner;

  	public Student_OldProgramsProxi(Student owner) {
    	this.owner = owner;
  	}
  	public ProgramStudentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ProgramStudentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudentFacade.oldProgramsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ProgramStudent4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ProgramStudent4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ProgramStudent4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ProgramStudentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudentFacade
        	               	.oldProgramsAdd(owner.getId(), entry);
      		}
      		list.add((ProgramStudent4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudentFacade.oldProgramsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Student_OldProgramsProxi copy(Student owner) throws PersistenceException {
  		Student_OldProgramsProxi result = new Student_OldProgramsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ProgramStudent4Public> entries = (this.list == null ? new java.util.Vector<ProgramStudent4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ProgramStudent4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudentFacade
            	           .oldProgramsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
