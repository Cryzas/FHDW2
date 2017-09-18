package persistence;

import model.*;

public class ModuleAtomarSGroupFacade{



	public ModuleAtomarSGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleAtomarSGroup newModuleAtomarSGroup(common.Fraction ownCreditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(idCreateIfLessZero, 179);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getNextId();
        ModuleAtomarSGroup result = new ModuleAtomarSGroup(null,null,null,null,ownCreditPoints,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(id, 179);
    }
    
    public PersistentModuleAtomarSGroup newDelayedModuleAtomarSGroup(common.Fraction ownCreditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getNextId();
        ModuleAtomarSGroup result = new ModuleAtomarSGroup(null,null,null,null,ownCreditPoints,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(id, 179);
    }
    
    public ModuleAtomarSGroup getModuleAtomarSGroup(long ModuleAtomarSGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void ownCreditPointsSet(long ModuleAtomarSGroupId, common.Fraction ownCreditPointsVal) throws PersistenceException {
        
    }
    public void gradeSystemSet(long ModuleAtomarSGroupId, GradeSystem4Public gradeSystemVal) throws PersistenceException {
        
    }

}

