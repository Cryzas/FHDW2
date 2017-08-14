package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleManager_ModulesProxi extends PersistentListProxi<ModuleAbstract4Public> {

  	private ModuleAbstractList list;
  	private ModuleManager owner;

  	public ModuleManager_ModulesProxi(ModuleManager owner) {
    	this.owner = owner;
  	}
  	public ModuleAbstractList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleAbstractList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleManagerFacade.modulesGet(this.owner.getId());
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
  	public void add(ModuleAbstract4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ModuleAbstractList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
        	               	.modulesAdd(owner.getId(), entry);
      		}
      		list.add((ModuleAbstract4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade.modulesRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleManager_ModulesProxi copy(ModuleManager owner) throws PersistenceException {
  		ModuleManager_ModulesProxi result = new ModuleManager_ModulesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleAbstract4Public> entries = (this.list == null ? new java.util.Vector<ModuleAbstract4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleAbstract4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
            	           .modulesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
