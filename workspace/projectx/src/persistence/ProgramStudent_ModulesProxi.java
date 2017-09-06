package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ProgramStudent_ModulesProxi extends PersistentListProxi<ModuleAbstractStudent4Public> {

  	private ModuleAbstractStudentList list;
  	private ProgramStudent owner;

  	public ProgramStudent_ModulesProxi(ProgramStudent owner) {
    	this.owner = owner;
  	}
  	public ModuleAbstractStudentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleAbstractStudentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theProgramStudentFacade.modulesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ModuleAbstractStudent4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ModuleAbstractStudent4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ModuleAbstractStudent4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsprogramHierarchyStudent(this.owner)) throw new model.CycleException("Cycle in programHierarchyStudent detected!");
			ModuleAbstractStudentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
        	               	.modulesAdd(owner.getId(), entry);
      		}
      		list.add((ModuleAbstractStudent4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.modulesRem(entry.getListEntryId());
    	}
    	
  	}
  	public ProgramStudent_ModulesProxi copy(ProgramStudent owner) throws PersistenceException {
  		ProgramStudent_ModulesProxi result = new ProgramStudent_ModulesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleAbstractStudent4Public> entries = (this.list == null ? new java.util.Vector<ModuleAbstractStudent4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleAbstractStudent4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
            	           .modulesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
