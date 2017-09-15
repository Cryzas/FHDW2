package persistence;

import model.meta.*;

public class EndStudyGroupCommandFacade{

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

	

	public EndStudyGroupCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentEndStudyGroupCommand newEndStudyGroupCommand(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentEndStudyGroupCommand)PersistentProxi.createProxi(idCreateIfLessZero, 284);
        long id = ConnectionHandler.getTheConnectionHandler().theEndStudyGroupCommandFacade.getNextId();
        EndStudyGroupCommand result = new EndStudyGroupCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentEndStudyGroupCommand)PersistentProxi.createProxi(id, 284);
    }
    
    public PersistentEndStudyGroupCommand newDelayedEndStudyGroupCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theEndStudyGroupCommandFacade.getNextId();
        EndStudyGroupCommand result = new EndStudyGroupCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentEndStudyGroupCommand)PersistentProxi.createProxi(id, 284);
    }
    
    public EndStudyGroupCommand getEndStudyGroupCommand(long EndStudyGroupCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 284)) return 284;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void studyGroupSet(long EndStudyGroupCommandId, StudyGroup4Public studyGroupVal) throws PersistenceException {
        
    }
    public void invokerSet(long EndStudyGroupCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long EndStudyGroupCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long EndStudyGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

