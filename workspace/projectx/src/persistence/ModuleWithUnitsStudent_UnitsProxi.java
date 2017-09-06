package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleWithUnitsStudent_UnitsProxi extends PersistentListProxi<UnitStudent4Public> {

  	private UnitStudentList list;
  	private ModuleWithUnitsStudent owner;

  	public ModuleWithUnitsStudent_UnitsProxi(ModuleWithUnitsStudent owner) {
    	this.owner = owner;
  	}
  	public UnitStudentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new UnitStudentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleWithUnitsStudentFacade.unitsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<UnitStudent4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<UnitStudent4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(UnitStudent4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsprogramHierarchyStudent(this.owner)) throw new model.CycleException("Cycle in programHierarchyStudent detected!");
			UnitStudentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
        	               	.unitsAdd(owner.getId(), entry);
      		}
      		list.add((UnitStudent4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade.unitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleWithUnitsStudent_UnitsProxi copy(ModuleWithUnitsStudent owner) throws PersistenceException {
  		ModuleWithUnitsStudent_UnitsProxi result = new ModuleWithUnitsStudent_UnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<UnitStudent4Public> entries = (this.list == null ? new java.util.Vector<UnitStudent4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			UnitStudent4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
            	           .unitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
