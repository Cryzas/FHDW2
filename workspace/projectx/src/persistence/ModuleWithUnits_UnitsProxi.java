package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleWithUnits_UnitsProxi extends PersistentListProxi<Unit4Public> {

  	private UnitList list;
  	private ModuleWithUnits owner;

  	public ModuleWithUnits_UnitsProxi(ModuleWithUnits owner) {
    	this.owner = owner;
  	}
  	public UnitList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new UnitList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleWithUnitsFacade.unitsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Unit4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Unit4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Unit4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsprogramHierarchy(this.owner)) throw new model.CycleException("Cycle in programHierarchy detected!");
			UnitList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
        	               	.unitsAdd(owner.getId(), entry);
      		}
      		list.add((Unit4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade.unitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleWithUnits_UnitsProxi copy(ModuleWithUnits owner) throws PersistenceException {
  		ModuleWithUnits_UnitsProxi result = new ModuleWithUnits_UnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Unit4Public> entries = (this.list == null ? new java.util.Vector<Unit4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Unit4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
            	           .unitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
