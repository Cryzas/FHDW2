package persistence;

import model.meta.*;

public class AddStudentToGroupCommandFacade{

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

	

	public AddStudentToGroupCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddStudentToGroupCommand newAddStudentToGroupCommand(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAddStudentToGroupCommand)PersistentProxi.createProxi(idCreateIfLessZero, 203);
        long id = ConnectionHandler.getTheConnectionHandler().theAddStudentToGroupCommandFacade.getNextId();
        AddStudentToGroupCommand result = new AddStudentToGroupCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddStudentToGroupCommand)PersistentProxi.createProxi(id, 203);
    }
    
    public PersistentAddStudentToGroupCommand newDelayedAddStudentToGroupCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddStudentToGroupCommandFacade.getNextId();
        AddStudentToGroupCommand result = new AddStudentToGroupCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddStudentToGroupCommand)PersistentProxi.createProxi(id, 203);
    }
    
    public AddStudentToGroupCommand getAddStudentToGroupCommand(long AddStudentToGroupCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 203)) return 203;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void groupSet(long AddStudentToGroupCommandId, StudyGroup4Public groupVal) throws PersistenceException {
        
    }
    public void studentSet(long AddStudentToGroupCommandId, Student4Public studentVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddStudentToGroupCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddStudentToGroupCommandId, StudentManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddStudentToGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

