package persistence;

import model.*;

public class ProgramManagerFacade{

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

	

	public ProgramManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramManager newProgramManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgramManager)PersistentProxi.createProxi(idCreateIfLessZero, 148);
        long id = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.getNextId();
        ProgramManager result = new ProgramManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramManager)PersistentProxi.createProxi(id, 148);
    }
    
    public PersistentProgramManager newDelayedProgramManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.getNextId();
        ProgramManager result = new ProgramManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramManager)PersistentProxi.createProxi(id, 148);
    }
    
    public ProgramManager getProgramManager(long ProgramManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 148)) return 148;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long programsAdd(long ProgramManagerId, Program4Public programsVal) throws PersistenceException {
        return 0;
    }
    public void programsRem(long programsId) throws PersistenceException {
        
    }
    public ProgramList programsGet(long ProgramManagerId) throws PersistenceException {
        return new ProgramList(); // remote access for initialization only!
    }
    public void subServiceSet(long ProgramManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProgramManagerId, ProgramManager4Public ThisVal) throws PersistenceException {
        
    }

}

