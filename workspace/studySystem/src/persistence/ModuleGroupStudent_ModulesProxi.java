package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleGroupStudent_ModulesProxi extends PersistentListProxi<ModuleAbstractStudent4Public> {

  	private ModuleAbstractStudentList list;
  	private ModuleGroupStudent owner;

  	public ModuleGroupStudent_ModulesProxi(ModuleGroupStudent owner) {
    	this.owner = owner;
  	}
  	public ModuleAbstractStudentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleAbstractStudentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleGroupStudentFacade.modulesGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
        	               	.modulesAdd(owner.getId(), entry);
      		}
      		list.add((ModuleAbstractStudent4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade.modulesRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleGroupStudent_ModulesProxi copy(ModuleGroupStudent owner) throws PersistenceException {
  		ModuleGroupStudent_ModulesProxi result = new ModuleGroupStudent_ModulesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleAbstractStudent4Public> entries = (this.list == null ? new java.util.Vector<ModuleAbstractStudent4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleAbstractStudent4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
            	           .modulesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
