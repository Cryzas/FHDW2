package persistence;

import model.meta.*;

public class CommonDateFacade{

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

	

	public CommonDateFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCommonDate newCommonDate(java.sql.Date createDate,java.sql.Date commitDate,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCommonDate)PersistentProxi.createProxi(idCreateIfLessZero, 104);
        long id = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.getNextId();
        CommonDate result = new CommonDate(createDate,commitDate,id);
        Cache.getTheCache().put(result);
        return (PersistentCommonDate)PersistentProxi.createProxi(id, 104);
    }
    
    public PersistentCommonDate newDelayedCommonDate(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.getNextId();
        CommonDate result = new CommonDate(createDate,commitDate,id);
        Cache.getTheCache().put(result);
        return (PersistentCommonDate)PersistentProxi.createProxi(id, 104);
    }
    
    public CommonDate getCommonDate(long CommonDateId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 104)) return 104;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void createDateSet(long CommonDateId, java.sql.Date createDateVal) throws PersistenceException {
        
    }
    public void commitDateSet(long CommonDateId, java.sql.Date commitDateVal) throws PersistenceException {
        
    }

}

