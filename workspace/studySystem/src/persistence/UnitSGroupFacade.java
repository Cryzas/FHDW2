package persistence;

import model.*;

public class UnitSGroupFacade{

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

	

	public UnitSGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUnitSGroup newUnitSGroup(common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentUnitSGroup)PersistentProxi.createProxi(idCreateIfLessZero, 181);
        long id = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.getNextId();
        UnitSGroup result = new UnitSGroup(null,creditPoints,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUnitSGroup)PersistentProxi.createProxi(id, 181);
    }
    
    public PersistentUnitSGroup newDelayedUnitSGroup(common.Fraction creditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.getNextId();
        UnitSGroup result = new UnitSGroup(null,creditPoints,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUnitSGroup)PersistentProxi.createProxi(id, 181);
    }
    
    public UnitSGroup getUnitSGroup(long UnitSGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 181)) return 181;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void unitCopySet(long UnitSGroupId, Unit4Public unitCopyVal) throws PersistenceException {
        
    }
    public void creditPointsSet(long UnitSGroupId, common.Fraction creditPointsVal) throws PersistenceException {
        
    }
    public void finishedSet(long UnitSGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        
    }
    public void ThisSet(long UnitSGroupId, UnitSGroup4Public ThisVal) throws PersistenceException {
        
    }

}

