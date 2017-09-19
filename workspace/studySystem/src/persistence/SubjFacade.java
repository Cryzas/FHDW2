package persistence;

import model.*;

public class SubjFacade{

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

	

	public SubjFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentSubj newSubj(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentSubj)PersistentProxi.createProxi(idCreateIfLessZero, 293);
        long id = ConnectionHandler.getTheConnectionHandler().theSubjFacade.getNextId();
        Subj result = new Subj(null,id);
        Cache.getTheCache().put(result);
        return (PersistentSubj)PersistentProxi.createProxi(id, 293);
    }
    
    public PersistentSubj newDelayedSubj() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theSubjFacade.getNextId();
        Subj result = new Subj(null,id);
        Cache.getTheCache().put(result);
        return (PersistentSubj)PersistentProxi.createProxi(id, 293);
    }
    
    public Subj getSubj(long SubjId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 293)) return 293;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long observeeAdd(long SubjId, ObsInterface observeeVal) throws PersistenceException {
        return 0;
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        
    }
    public ObsInterfaceList observeeGet(long SubjId) throws PersistenceException {
        return new ObsInterfaceList(); // remote access for initialization only!
    }
    public void ThisSet(long SubjId, Subj4Public ThisVal) throws PersistenceException {
        
    }

}

