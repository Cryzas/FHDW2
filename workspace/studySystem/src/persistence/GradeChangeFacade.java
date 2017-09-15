package persistence;

import model.*;

public class GradeChangeFacade{

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

	

	public GradeChangeFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentGradeChange newGradeChange(java.sql.Date dateOfChange,String comment,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentGradeChange)PersistentProxi.createProxi(idCreateIfLessZero, 276);
        long id = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.getNextId();
        GradeChange result = new GradeChange(null,null,dateOfChange,comment,null,id);
        Cache.getTheCache().put(result);
        return (PersistentGradeChange)PersistentProxi.createProxi(id, 276);
    }
    
    public PersistentGradeChange newDelayedGradeChange(java.sql.Date dateOfChange,String comment) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.getNextId();
        GradeChange result = new GradeChange(null,null,dateOfChange,comment,null,id);
        Cache.getTheCache().put(result);
        return (PersistentGradeChange)PersistentProxi.createProxi(id, 276);
    }
    
    public GradeChange getGradeChange(long GradeChangeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 276)) return 276;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void fromGradeSet(long GradeChangeId, Grade4Public fromGradeVal) throws PersistenceException {
        
    }
    public void toGradeSet(long GradeChangeId, Grade4Public toGradeVal) throws PersistenceException {
        
    }
    public void dateOfChangeSet(long GradeChangeId, java.sql.Date dateOfChangeVal) throws PersistenceException {
        
    }
    public void commentSet(long GradeChangeId, String commentVal) throws PersistenceException {
        
    }
    public void ThisSet(long GradeChangeId, GradeChange4Public ThisVal) throws PersistenceException {
        
    }

}

