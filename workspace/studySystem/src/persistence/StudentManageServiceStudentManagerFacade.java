package persistence;

import model.*;

public class StudentManageServiceStudentManagerFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public StudentManageServiceStudentManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentManageServiceStudentManager newStudentManageServiceStudentManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(idCreateIfLessZero, 311);
        long id = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.getNextId();
        StudentManageServiceStudentManager result = new StudentManageServiceStudentManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(id, 311);
    }
    
    public PersistentStudentManageServiceStudentManager newDelayedStudentManageServiceStudentManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.getNextId();
        StudentManageServiceStudentManager result = new StudentManageServiceStudentManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(id, 311);
    }
    
    public StudentManageServiceStudentManager getStudentManageServiceStudentManager(long StudentManageServiceStudentManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 311)) return 311;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long StudentManageServiceStudentManagerId, StudentManageService4Public observerVal) throws PersistenceException {
        
    }
    public void observeeSet(long StudentManageServiceStudentManagerId, StudentManager4Public observeeVal) throws PersistenceException {
        
    }
    public void ThisSet(long StudentManageServiceStudentManagerId, StudentManageServiceStudentManager4Public ThisVal) throws PersistenceException {
        
    }

}

