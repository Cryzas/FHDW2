package persistence;

import model.*;

public class ModuleWithUnitsStudentFacade{



	public ModuleWithUnitsStudentFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithUnitsStudent newModuleWithUnitsStudent(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleWithUnitsStudent)PersistentProxi.createProxi(idCreateIfLessZero, 193);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getNextId();
        ModuleWithUnitsStudent result = new ModuleWithUnitsStudent(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleWithUnitsStudent)PersistentProxi.createProxi(id, 193);
    }
    
    public PersistentModuleWithUnitsStudent newDelayedModuleWithUnitsStudent() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getNextId();
        ModuleWithUnitsStudent result = new ModuleWithUnitsStudent(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleWithUnitsStudent)PersistentProxi.createProxi(id, 193);
    }
    
    public ModuleWithUnitsStudent getModuleWithUnitsStudent(long ModuleWithUnitsStudentId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long unitsAdd(long ModuleWithUnitsStudentId, UnitStudent4Public unitsVal) throws PersistenceException {
        return 0;
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        
    }
    public UnitStudentList unitsGet(long ModuleWithUnitsStudentId) throws PersistenceException {
        return new UnitStudentList(); // remote access for initialization only!
    }

}

