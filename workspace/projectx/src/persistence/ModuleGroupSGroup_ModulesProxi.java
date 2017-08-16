package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleGroupSGroup_ModulesProxi extends PersistentListProxi<ModuleAbstractSGroup4Public> {

  	private ModuleAbstractSGroupList list;
  	private ModuleGroupSGroup owner;

  	public ModuleGroupSGroup_ModulesProxi(ModuleGroupSGroup owner) {
    	this.owner = owner;
  	}
  	public ModuleAbstractSGroupList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleAbstractSGroupList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleGroupSGroupFacade.modulesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ModuleAbstractSGroup4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ModuleAbstractSGroup4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ModuleAbstractSGroup4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsprogramHierarchySGroup(this.owner)) throw new model.CycleException("Cycle in programHierarchySGroup detected!");
			ModuleAbstractSGroupList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
        	               	.modulesAdd(owner.getId(), entry);
      		}
      		list.add((ModuleAbstractSGroup4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade.modulesRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleGroupSGroup_ModulesProxi copy(ModuleGroupSGroup owner) throws PersistenceException {
  		ModuleGroupSGroup_ModulesProxi result = new ModuleGroupSGroup_ModulesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleAbstractSGroup4Public> entries = (this.list == null ? new java.util.Vector<ModuleAbstractSGroup4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleAbstractSGroup4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
            	           .modulesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
