package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class StudyGroup_StudentsProxi extends PersistentListProxi<Student4Public> {

  	private StudentList list;
  	private StudyGroup owner;

  	public StudyGroup_StudentsProxi(StudyGroup owner) {
    	this.owner = owner;
  	}
  	public StudentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new StudentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudyGroupFacade.studentsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Student4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Student4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Student4Public entry) throws PersistenceException {
    	if (entry != null) {
      		StudentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
        	               	.studentsAdd(owner.getId(), entry);
      		}
      		list.add((Student4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsRem(entry.getListEntryId());
    	}
    	
  	}
  	public StudyGroup_StudentsProxi copy(StudyGroup owner) throws PersistenceException {
  		StudyGroup_StudentsProxi result = new StudyGroup_StudentsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Student4Public> entries = (this.list == null ? new java.util.Vector<Student4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Student4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
            	           .studentsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
