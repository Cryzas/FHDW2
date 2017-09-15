package persistence;

import model.*;

public class ModuleWithUnitsSGroupFacade{



	public ModuleWithUnitsSGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithUnitsSGroup newModuleWithUnitsSGroup(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(idCreateIfLessZero, 182);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getNextId();
        ModuleWithUnitsSGroup result = new ModuleWithUnitsSGroup(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(id, 182);
    }
    
    public PersistentModuleWithUnitsSGroup newDelayedModuleWithUnitsSGroup() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getNextId();
        ModuleWithUnitsSGroup result = new ModuleWithUnitsSGroup(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(id, 182);
    }
    
    public ModuleWithUnitsSGroup getModuleWithUnitsSGroup(long ModuleWithUnitsSGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long unitsAdd(long ModuleWithUnitsSGroupId, UnitSGroup4Public unitsVal) throws PersistenceException {
        return 0;
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        
    }
    public UnitSGroupList unitsGet(long ModuleWithUnitsSGroupId) throws PersistenceException {
        return new UnitSGroupList(); // remote access for initialization only!
    }

}

