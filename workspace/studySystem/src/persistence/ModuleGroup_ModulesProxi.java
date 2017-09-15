package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleGroup_ModulesProxi extends PersistentListProxi<ModuleAbstract4Public> {

  	private ModuleAbstractList list;
  	private ModuleGroup owner;

  	public ModuleGroup_ModulesProxi(ModuleGroup owner) {
    	this.owner = owner;
  	}
  	public ModuleAbstractList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleAbstractList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleGroupFacade.modulesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ModuleAbstract4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ModuleAbstract4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ModuleAbstract4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsprogramHierarchy(this.owner)) throw new model.CycleException("Cycle in programHierarchy detected!");
			ModuleAbstractList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
        	               	.modulesAdd(owner.getId(), entry);
      		}
      		list.add((ModuleAbstract4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade.modulesRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleGroup_ModulesProxi copy(ModuleGroup owner) throws PersistenceException {
  		ModuleGroup_ModulesProxi result = new ModuleGroup_ModulesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleAbstract4Public> entries = (this.list == null ? new java.util.Vector<ModuleAbstract4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleAbstract4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
            	           .modulesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
