package persistence;

import model.*;

public class ModuleAtomarStudentFacade{



	public ModuleAtomarStudentFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleAtomarStudent newModuleAtomarStudent(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleAtomarStudent)PersistentProxi.createProxi(idCreateIfLessZero, 191);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getNextId();
        ModuleAtomarStudent result = new ModuleAtomarStudent(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleAtomarStudent)PersistentProxi.createProxi(id, 191);
    }
    
    public PersistentModuleAtomarStudent newDelayedModuleAtomarStudent() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getNextId();
        ModuleAtomarStudent result = new ModuleAtomarStudent(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleAtomarStudent)PersistentProxi.createProxi(id, 191);
    }
    
    public ModuleAtomarStudent getModuleAtomarStudent(long ModuleAtomarStudentId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void ownGradeSet(long ModuleAtomarStudentId, GradesInSimpleOrThird4Public ownGradeVal) throws PersistenceException {
        
    }
    public long changesAdd(long ModuleAtomarStudentId, GradeChange4Public changesVal) throws PersistenceException {
        return 0;
    }
    public void changesRem(long changesId) throws PersistenceException {
        
    }
    public GradeChangeList changesGet(long ModuleAtomarStudentId) throws PersistenceException {
        return new GradeChangeList(); // remote access for initialization only!
    }

}

