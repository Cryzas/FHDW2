package persistence;

import model.*;

public class StudentManagerFacade{

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

	

	public StudentManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentManager newStudentManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudentManager)PersistentProxi.createProxi(idCreateIfLessZero, 201);
        long id = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade.getNextId();
        StudentManager result = new StudentManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentManager)PersistentProxi.createProxi(id, 201);
    }
    
    public PersistentStudentManager newDelayedStudentManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade.getNextId();
        StudentManager result = new StudentManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentManager)PersistentProxi.createProxi(id, 201);
    }
    
    public StudentManager getStudentManager(long StudentManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 201)) return 201;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long studentsAdd(long StudentManagerId, Student4Public studentsVal) throws PersistenceException {
        return 0;
    }
    public void studentsRem(long studentsId) throws PersistenceException {
        
    }
    public StudentList studentsGet(long StudentManagerId) throws PersistenceException {
        return new StudentList(); // remote access for initialization only!
    }
    public void subServiceSet(long StudentManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long StudentManagerId, StudentManager4Public ThisVal) throws PersistenceException {
        
    }

}

