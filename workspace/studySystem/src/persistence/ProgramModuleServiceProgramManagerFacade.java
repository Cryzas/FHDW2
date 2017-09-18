package persistence;

import model.*;

public class ProgramModuleServiceProgramManagerFacade{

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

	

	public ProgramModuleServiceProgramManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramModuleServiceProgramManager newProgramModuleServiceProgramManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(idCreateIfLessZero, 309);
        long id = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.getNextId();
        ProgramModuleServiceProgramManager result = new ProgramModuleServiceProgramManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(id, 309);
    }
    
    public PersistentProgramModuleServiceProgramManager newDelayedProgramModuleServiceProgramManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.getNextId();
        ProgramModuleServiceProgramManager result = new ProgramModuleServiceProgramManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(id, 309);
    }
    
    public ProgramModuleServiceProgramManager getProgramModuleServiceProgramManager(long ProgramModuleServiceProgramManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 309)) return 309;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long ProgramModuleServiceProgramManagerId, ProgramModuleService4Public observerVal) throws PersistenceException {
        
    }
    public void observeeSet(long ProgramModuleServiceProgramManagerId, ProgramManager4Public observeeVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProgramModuleServiceProgramManagerId, ProgramModuleServiceProgramManager4Public ThisVal) throws PersistenceException {
        
    }

}

