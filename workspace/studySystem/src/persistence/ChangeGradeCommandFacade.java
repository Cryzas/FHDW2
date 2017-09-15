package persistence;

import model.meta.*;

public class ChangeGradeCommandFacade{

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

	

	public ChangeGradeCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeCommand newChangeGradeCommand(String grade,String comment,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentChangeGradeCommand)PersistentProxi.createProxi(idCreateIfLessZero, 275);
        long id = ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.getNextId();
        ChangeGradeCommand result = new ChangeGradeCommand(null,grade,comment,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeGradeCommand)PersistentProxi.createProxi(id, 275);
    }
    
    public PersistentChangeGradeCommand newDelayedChangeGradeCommand(String grade,String comment) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.getNextId();
        ChangeGradeCommand result = new ChangeGradeCommand(null,grade,comment,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeGradeCommand)PersistentProxi.createProxi(id, 275);
    }
    
    public ChangeGradeCommand getChangeGradeCommand(long ChangeGradeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 275)) return 275;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void lectureSet(long ChangeGradeCommandId, LectureWithGrade lectureVal) throws PersistenceException {
        
    }
    public void gradeSet(long ChangeGradeCommandId, String gradeVal) throws PersistenceException {
        
    }
    public void commentSet(long ChangeGradeCommandId, String commentVal) throws PersistenceException {
        
    }
    public void invokerSet(long ChangeGradeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long ChangeGradeCommandId, StudentManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long ChangeGradeCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

