package persistence;

import model.*;

public class ProgramStudentFacade{

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

	

	public ProgramStudentFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramStudent newProgramStudent(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgramStudent)PersistentProxi.createProxi(idCreateIfLessZero, 192);
        long id = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.getNextId();
        ProgramStudent result = new ProgramStudent(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramStudent)PersistentProxi.createProxi(id, 192);
    }
    
    public PersistentProgramStudent newDelayedProgramStudent() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.getNextId();
        ProgramStudent result = new ProgramStudent(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramStudent)PersistentProxi.createProxi(id, 192);
    }
    
    public ProgramStudent getProgramStudent(long ProgramStudentId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 285)) return 285;
        if(Cache.getTheCache().contains(objectId, 192)) return 192;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long modulesAdd(long ProgramStudentId, ModuleAbstractStudent4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractStudentList modulesGet(long ProgramStudentId) throws PersistenceException {
        return new ModuleAbstractStudentList(); // remote access for initialization only!
    }
    public void programCopySet(long ProgramStudentId, ProgramSGroup4Public programCopyVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProgramStudentId, ProgramStudent4Public ThisVal) throws PersistenceException {
        
    }

}

