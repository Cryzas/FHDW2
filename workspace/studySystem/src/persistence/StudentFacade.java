package persistence;

import model.*;

public class StudentFacade{

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

	

	public StudentFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudent newStudent(String firstName,String lastName,java.sql.Date birthDate,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudent)PersistentProxi.createProxi(idCreateIfLessZero, 195);
        long id = ConnectionHandler.getTheConnectionHandler().theStudentFacade.getNextId();
        Student result = new Student(firstName,lastName,birthDate,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudent)PersistentProxi.createProxi(id, 195);
    }
    
    public PersistentStudent newDelayedStudent(String firstName,String lastName,java.sql.Date birthDate) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStudentFacade.getNextId();
        Student result = new Student(firstName,lastName,birthDate,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudent)PersistentProxi.createProxi(id, 195);
    }
    
    public Student getStudent(long StudentId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 195)) return 195;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void firstNameSet(long StudentId, String firstNameVal) throws PersistenceException {
        
    }
    public void lastNameSet(long StudentId, String lastNameVal) throws PersistenceException {
        
    }
    public void birthDateSet(long StudentId, java.sql.Date birthDateVal) throws PersistenceException {
        
    }
    public void programSet(long StudentId, ProgramStudent4Public programVal) throws PersistenceException {
        
    }
    public long oldProgramsAdd(long StudentId, ProgramStudent4Public oldProgramsVal) throws PersistenceException {
        return 0;
    }
    public void oldProgramsRem(long oldProgramsId) throws PersistenceException {
        
    }
    public ProgramStudentList oldProgramsGet(long StudentId) throws PersistenceException {
        return new ProgramStudentList(); // remote access for initialization only!
    }
    public void subServiceSet(long StudentId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long StudentId, Student4Public ThisVal) throws PersistenceException {
        
    }

}

