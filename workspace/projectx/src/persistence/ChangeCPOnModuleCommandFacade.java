package persistence;

import model.meta.*;

public class ChangeCPOnModuleCommandFacade{

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

	

	public ChangeCPOnModuleCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeCPOnModuleCommand newChangeCPOnModuleCommand(common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentChangeCPOnModuleCommand)PersistentProxi.createProxi(idCreateIfLessZero, 156);
        long id = ConnectionHandler.getTheConnectionHandler().theChangeCPOnModuleCommandFacade.getNextId();
        ChangeCPOnModuleCommand result = new ChangeCPOnModuleCommand(null,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeCPOnModuleCommand)PersistentProxi.createProxi(id, 156);
    }
    
    public PersistentChangeCPOnModuleCommand newDelayedChangeCPOnModuleCommand(common.Fraction creditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theChangeCPOnModuleCommandFacade.getNextId();
        ChangeCPOnModuleCommand result = new ChangeCPOnModuleCommand(null,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeCPOnModuleCommand)PersistentProxi.createProxi(id, 156);
    }
    
    public ChangeCPOnModuleCommand getChangeCPOnModuleCommand(long ChangeCPOnModuleCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 156)) return 156;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void moduleSet(long ChangeCPOnModuleCommandId, ModuleAtomar4Public moduleVal) throws PersistenceException {
        
    }
    public void creditPointsSet(long ChangeCPOnModuleCommandId, common.Fraction creditPointsVal) throws PersistenceException {
        
    }
    public void invokerSet(long ChangeCPOnModuleCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long ChangeCPOnModuleCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long ChangeCPOnModuleCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

