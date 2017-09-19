package persistence;

import model.meta.*;

public class CreateStudentCommandFacade{

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

	

	public CreateStudentCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateStudentCommand newCreateStudentCommand(String firstName,String lastName,java.sql.Date birthDate,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCreateStudentCommand)PersistentProxi.createProxi(idCreateIfLessZero, 200);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.getNextId();
        CreateStudentCommand result = new CreateStudentCommand(null,firstName,lastName,birthDate,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateStudentCommand)PersistentProxi.createProxi(id, 200);
    }
    
    public PersistentCreateStudentCommand newDelayedCreateStudentCommand(String firstName,String lastName,java.sql.Date birthDate) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.getNextId();
        CreateStudentCommand result = new CreateStudentCommand(null,firstName,lastName,birthDate,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateStudentCommand)PersistentProxi.createProxi(id, 200);
    }
    
    public CreateStudentCommand getCreateStudentCommand(long CreateStudentCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 200)) return 200;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void groupSet(long CreateStudentCommandId, StudyGroup4Public groupVal) throws PersistenceException {
        
    }
    public void firstNameSet(long CreateStudentCommandId, String firstNameVal) throws PersistenceException {
        
    }
    public void lastNameSet(long CreateStudentCommandId, String lastNameVal) throws PersistenceException {
        
    }
    public void birthDateSet(long CreateStudentCommandId, java.sql.Date birthDateVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateStudentCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateStudentCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateStudentCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

