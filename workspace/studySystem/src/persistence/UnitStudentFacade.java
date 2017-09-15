package persistence;

import model.*;

public class UnitStudentFacade{

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

	

	public UnitStudentFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUnitStudent newUnitStudent(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentUnitStudent)PersistentProxi.createProxi(idCreateIfLessZero, 197);
        long id = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.getNextId();
        UnitStudent result = new UnitStudent(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUnitStudent)PersistentProxi.createProxi(id, 197);
    }
    
    public PersistentUnitStudent newDelayedUnitStudent() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.getNextId();
        UnitStudent result = new UnitStudent(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUnitStudent)PersistentProxi.createProxi(id, 197);
    }
    
    public UnitStudent getUnitStudent(long UnitStudentId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 197)) return 197;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void unitCopySet(long UnitStudentId, UnitSGroup4Public unitCopyVal) throws PersistenceException {
        
    }
    public void gradeSet(long UnitStudentId, GradesInThird4Public gradeVal) throws PersistenceException {
        
    }
    public long changesAdd(long UnitStudentId, GradeChange4Public changesVal) throws PersistenceException {
        return 0;
    }
    public void changesRem(long changesId) throws PersistenceException {
        
    }
    public GradeChangeList changesGet(long UnitStudentId) throws PersistenceException {
        return new GradeChangeList(); // remote access for initialization only!
    }
    public void ThisSet(long UnitStudentId, UnitStudent4Public ThisVal) throws PersistenceException {
        
    }

}

