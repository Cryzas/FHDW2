package persistence;

import model.meta.*;

public class ChangeCPOnUnitCommandFacade{

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

	

	public ChangeCPOnUnitCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeCPOnUnitCommand newChangeCPOnUnitCommand(common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentChangeCPOnUnitCommand)PersistentProxi.createProxi(idCreateIfLessZero, 157);
        long id = ConnectionHandler.getTheConnectionHandler().theChangeCPOnUnitCommandFacade.getNextId();
        ChangeCPOnUnitCommand result = new ChangeCPOnUnitCommand(null,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeCPOnUnitCommand)PersistentProxi.createProxi(id, 157);
    }
    
    public PersistentChangeCPOnUnitCommand newDelayedChangeCPOnUnitCommand(common.Fraction creditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theChangeCPOnUnitCommandFacade.getNextId();
        ChangeCPOnUnitCommand result = new ChangeCPOnUnitCommand(null,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeCPOnUnitCommand)PersistentProxi.createProxi(id, 157);
    }
    
    public ChangeCPOnUnitCommand getChangeCPOnUnitCommand(long ChangeCPOnUnitCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 157)) return 157;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void unitSet(long ChangeCPOnUnitCommandId, Unit4Public unitVal) throws PersistenceException {
        
    }
    public void creditPointsSet(long ChangeCPOnUnitCommandId, common.Fraction creditPointsVal) throws PersistenceException {
        
    }
    public void invokerSet(long ChangeCPOnUnitCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long ChangeCPOnUnitCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long ChangeCPOnUnitCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

