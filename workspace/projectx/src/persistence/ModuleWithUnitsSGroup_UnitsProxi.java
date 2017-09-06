package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleWithUnitsSGroup_UnitsProxi extends PersistentListProxi<UnitSGroup4Public> {

  	private UnitSGroupList list;
  	private ModuleWithUnitsSGroup owner;

  	public ModuleWithUnitsSGroup_UnitsProxi(ModuleWithUnitsSGroup owner) {
    	this.owner = owner;
  	}
  	public UnitSGroupList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new UnitSGroupList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleWithUnitsSGroupFacade.unitsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<UnitSGroup4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<UnitSGroup4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(UnitSGroup4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsprogramHierarchySGroup(this.owner)) throw new model.CycleException("Cycle in programHierarchySGroup detected!");
			UnitSGroupList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
        	               	.unitsAdd(owner.getId(), entry);
      		}
      		list.add((UnitSGroup4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade.unitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleWithUnitsSGroup_UnitsProxi copy(ModuleWithUnitsSGroup owner) throws PersistenceException {
  		ModuleWithUnitsSGroup_UnitsProxi result = new ModuleWithUnitsSGroup_UnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<UnitSGroup4Public> entries = (this.list == null ? new java.util.Vector<UnitSGroup4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			UnitSGroup4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
            	           .unitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
