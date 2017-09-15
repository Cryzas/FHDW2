package persistence;

import model.meta.*;

public class AddUnitCommandFacade{

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

	

	public AddUnitCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddUnitCommand newAddUnitCommand(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAddUnitCommand)PersistentProxi.createProxi(idCreateIfLessZero, 161);
        long id = ConnectionHandler.getTheConnectionHandler().theAddUnitCommandFacade.getNextId();
        AddUnitCommand result = new AddUnitCommand(null,name,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddUnitCommand)PersistentProxi.createProxi(id, 161);
    }
    
    public PersistentAddUnitCommand newDelayedAddUnitCommand(String name,common.Fraction creditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddUnitCommandFacade.getNextId();
        AddUnitCommand result = new AddUnitCommand(null,name,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddUnitCommand)PersistentProxi.createProxi(id, 161);
    }
    
    public AddUnitCommand getAddUnitCommand(long AddUnitCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 161)) return 161;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void moduleSet(long AddUnitCommandId, ModuleWithUnits4Public moduleVal) throws PersistenceException {
        
    }
    public void nameSet(long AddUnitCommandId, String nameVal) throws PersistenceException {
        
    }
    public void creditPointsSet(long AddUnitCommandId, common.Fraction creditPointsVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddUnitCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddUnitCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddUnitCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

