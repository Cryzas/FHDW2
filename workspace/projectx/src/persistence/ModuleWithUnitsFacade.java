package persistence;

import model.*;

public class ModuleWithUnitsFacade{



	public ModuleWithUnitsFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithUnits newModuleWithUnits(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleWithUnits)PersistentProxi.createProxi(idCreateIfLessZero, 154);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getNextId();
        ModuleWithUnits result = new ModuleWithUnits(name,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleWithUnits)PersistentProxi.createProxi(id, 154);
    }
    
    public PersistentModuleWithUnits newDelayedModuleWithUnits(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getNextId();
        ModuleWithUnits result = new ModuleWithUnits(name,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleWithUnits)PersistentProxi.createProxi(id, 154);
    }
    
    public ModuleWithUnits getModuleWithUnits(long ModuleWithUnitsId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long unitsAdd(long ModuleWithUnitsId, Unit4Public unitsVal) throws PersistenceException {
        return 0;
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        
    }
    public UnitList unitsGet(long ModuleWithUnitsId) throws PersistenceException {
        return new UnitList(); // remote access for initialization only!
    }

}

