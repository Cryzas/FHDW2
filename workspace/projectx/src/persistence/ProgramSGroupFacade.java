package persistence;

import model.*;

public class ProgramSGroupFacade{

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

	

	public ProgramSGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramSGroup newProgramSGroup(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgramSGroup)PersistentProxi.createProxi(idCreateIfLessZero, 177);
        long id = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.getNextId();
        ProgramSGroup result = new ProgramSGroup(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramSGroup)PersistentProxi.createProxi(id, 177);
    }
    
    public PersistentProgramSGroup newDelayedProgramSGroup() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.getNextId();
        ProgramSGroup result = new ProgramSGroup(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramSGroup)PersistentProxi.createProxi(id, 177);
    }
    
    public ProgramSGroup getProgramSGroup(long ProgramSGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 177)) return 177;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long modulesAdd(long ProgramSGroupId, ModuleAbstractSGroup4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractSGroupList modulesGet(long ProgramSGroupId) throws PersistenceException {
        return new ModuleAbstractSGroupList(); // remote access for initialization only!
    }
    public void programCopySet(long ProgramSGroupId, Program4Public programCopyVal) throws PersistenceException {
        
    }
    public void finishedSet(long ProgramSGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProgramSGroupId, ProgramSGroup4Public ThisVal) throws PersistenceException {
        
    }

}

