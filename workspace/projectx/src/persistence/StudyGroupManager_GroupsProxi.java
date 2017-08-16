package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class StudyGroupManager_GroupsProxi extends PersistentListProxi<StudyGroup4Public> {

  	private StudyGroupList list;
  	private StudyGroupManager owner;

  	public StudyGroupManager_GroupsProxi(StudyGroupManager owner) {
    	this.owner = owner;
  	}
  	public StudyGroupList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new StudyGroupList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudyGroupManagerFacade.groupsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<StudyGroup4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<StudyGroup4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(StudyGroup4Public entry) throws PersistenceException {
    	if (entry != null) {
      		StudyGroupList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
        	               	.groupsAdd(owner.getId(), entry);
      		}
      		list.add((StudyGroup4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.groupsRem(entry.getListEntryId());
    	}
    	
  	}
  	public StudyGroupManager_GroupsProxi copy(StudyGroupManager owner) throws PersistenceException {
  		StudyGroupManager_GroupsProxi result = new StudyGroupManager_GroupsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<StudyGroup4Public> entries = (this.list == null ? new java.util.Vector<StudyGroup4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			StudyGroup4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
            	           .groupsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
