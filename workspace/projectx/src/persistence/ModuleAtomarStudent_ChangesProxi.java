package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleAtomarStudent_ChangesProxi extends PersistentListProxi<GradeChange4Public> {

  	private GradeChangeList list;
  	private ModuleAtomarStudent owner;

  	public ModuleAtomarStudent_ChangesProxi(ModuleAtomarStudent owner) {
    	this.owner = owner;
  	}
  	public GradeChangeList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new GradeChangeList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleAtomarStudentFacade.changesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<GradeChange4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<GradeChange4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(GradeChange4Public entry) throws PersistenceException {
    	if (entry != null) {
      		GradeChangeList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
        	               	.changesAdd(owner.getId(), entry);
      		}
      		list.add((GradeChange4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade.changesRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleAtomarStudent_ChangesProxi copy(ModuleAtomarStudent owner) throws PersistenceException {
  		ModuleAtomarStudent_ChangesProxi result = new ModuleAtomarStudent_ChangesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<GradeChange4Public> entries = (this.list == null ? new java.util.Vector<GradeChange4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			GradeChange4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
            	           .changesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
