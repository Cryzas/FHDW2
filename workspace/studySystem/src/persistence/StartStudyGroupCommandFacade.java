package persistence;

import model.meta.*;

public class StartStudyGroupCommandFacade{

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

	

	public StartStudyGroupCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStartStudyGroupCommand newStartStudyGroupCommand(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStartStudyGroupCommand)PersistentProxi.createProxi(idCreateIfLessZero, 185);
        long id = ConnectionHandler.getTheConnectionHandler().theStartStudyGroupCommandFacade.getNextId();
        StartStudyGroupCommand result = new StartStudyGroupCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStartStudyGroupCommand)PersistentProxi.createProxi(id, 185);
    }
    
    public PersistentStartStudyGroupCommand newDelayedStartStudyGroupCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStartStudyGroupCommandFacade.getNextId();
        StartStudyGroupCommand result = new StartStudyGroupCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStartStudyGroupCommand)PersistentProxi.createProxi(id, 185);
    }
    
    public StartStudyGroupCommand getStartStudyGroupCommand(long StartStudyGroupCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 185)) return 185;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void programSet(long StartStudyGroupCommandId, Program4Public programVal) throws PersistenceException {
        
    }
    public void nameSet(long StartStudyGroupCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long StartStudyGroupCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long StartStudyGroupCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long StartStudyGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

