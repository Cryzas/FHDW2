package persistence;

import model.*;

public class ProgramModuleServiceModuleManagerFacade{

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

	

	public ProgramModuleServiceModuleManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramModuleServiceModuleManager newProgramModuleServiceModuleManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(idCreateIfLessZero, 310);
        long id = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.getNextId();
        ProgramModuleServiceModuleManager result = new ProgramModuleServiceModuleManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(id, 310);
    }
    
    public PersistentProgramModuleServiceModuleManager newDelayedProgramModuleServiceModuleManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.getNextId();
        ProgramModuleServiceModuleManager result = new ProgramModuleServiceModuleManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(id, 310);
    }
    
    public ProgramModuleServiceModuleManager getProgramModuleServiceModuleManager(long ProgramModuleServiceModuleManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 310)) return 310;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long ProgramModuleServiceModuleManagerId, ProgramModuleService4Public observerVal) throws PersistenceException {
        
    }
    public void observeeSet(long ProgramModuleServiceModuleManagerId, ModuleManager4Public observeeVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProgramModuleServiceModuleManagerId, ProgramModuleServiceModuleManager4Public ThisVal) throws PersistenceException {
        
    }

}

