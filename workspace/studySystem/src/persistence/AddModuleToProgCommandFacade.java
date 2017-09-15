package persistence;

import model.meta.*;

public class AddModuleToProgCommandFacade{

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

	

	public AddModuleToProgCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddModuleToProgCommand newAddModuleToProgCommand(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAddModuleToProgCommand)PersistentProxi.createProxi(idCreateIfLessZero, 168);
        long id = ConnectionHandler.getTheConnectionHandler().theAddModuleToProgCommandFacade.getNextId();
        AddModuleToProgCommand result = new AddModuleToProgCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddModuleToProgCommand)PersistentProxi.createProxi(id, 168);
    }
    
    public PersistentAddModuleToProgCommand newDelayedAddModuleToProgCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddModuleToProgCommandFacade.getNextId();
        AddModuleToProgCommand result = new AddModuleToProgCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddModuleToProgCommand)PersistentProxi.createProxi(id, 168);
    }
    
    public AddModuleToProgCommand getAddModuleToProgCommand(long AddModuleToProgCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 168)) return 168;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void programSet(long AddModuleToProgCommandId, Program4Public programVal) throws PersistenceException {
        
    }
    public void moduleSet(long AddModuleToProgCommandId, ModuleAbstract4Public moduleVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddModuleToProgCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddModuleToProgCommandId, ProgramManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddModuleToProgCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

