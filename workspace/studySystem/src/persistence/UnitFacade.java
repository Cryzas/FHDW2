package persistence;

import model.*;

public class UnitFacade{

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

	

	public UnitFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUnit newUnit(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentUnit)PersistentProxi.createProxi(idCreateIfLessZero, 147);
        long id = ConnectionHandler.getTheConnectionHandler().theUnitFacade.getNextId();
        Unit result = new Unit(name,creditPoints,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUnit)PersistentProxi.createProxi(id, 147);
    }
    
    public PersistentUnit newDelayedUnit(String name,common.Fraction creditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theUnitFacade.getNextId();
        Unit result = new Unit(name,creditPoints,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUnit)PersistentProxi.createProxi(id, 147);
    }
    
    public Unit getUnit(long UnitId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 147)) return 147;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long UnitId, String nameVal) throws PersistenceException {
        
    }
    public void creditPointsSet(long UnitId, common.Fraction creditPointsVal) throws PersistenceException {
        
    }
    public void subServiceSet(long UnitId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long UnitId, Unit4Public ThisVal) throws PersistenceException {
        
    }

}

