package persistence;

import model.*;

public class ModuleAtomarFacade{



	public ModuleAtomarFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleAtomar newModuleAtomar(String name,common.Fraction ownCreditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleAtomar)PersistentProxi.createProxi(idCreateIfLessZero, 153);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getNextId();
        ModuleAtomar result = new ModuleAtomar(name,null,null,ownCreditPoints,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleAtomar)PersistentProxi.createProxi(id, 153);
    }
    
    public PersistentModuleAtomar newDelayedModuleAtomar(String name,common.Fraction ownCreditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getNextId();
        ModuleAtomar result = new ModuleAtomar(name,null,null,ownCreditPoints,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleAtomar)PersistentProxi.createProxi(id, 153);
    }
    
    public ModuleAtomar getModuleAtomar(long ModuleAtomarId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void ownCreditPointsSet(long ModuleAtomarId, common.Fraction ownCreditPointsVal) throws PersistenceException {
        
    }
    public void gradeSystemSet(long ModuleAtomarId, GradeSystem4Public gradeSystemVal) throws PersistenceException {
        
    }

}

