package persistence;

import model.meta.*;

public class ChangeGradeSystemCommandFacade{

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

	

	public ChangeGradeSystemCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeSystemCommand newChangeGradeSystemCommand(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentChangeGradeSystemCommand)PersistentProxi.createProxi(idCreateIfLessZero, 211);
        long id = ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.getNextId();
        ChangeGradeSystemCommand result = new ChangeGradeSystemCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeGradeSystemCommand)PersistentProxi.createProxi(id, 211);
    }
    
    public PersistentChangeGradeSystemCommand newDelayedChangeGradeSystemCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.getNextId();
        ChangeGradeSystemCommand result = new ChangeGradeSystemCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentChangeGradeSystemCommand)PersistentProxi.createProxi(id, 211);
    }
    
    public ChangeGradeSystemCommand getChangeGradeSystemCommand(long ChangeGradeSystemCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 211)) return 211;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void moduleSet(long ChangeGradeSystemCommandId, ModuleAtomar4Public moduleVal) throws PersistenceException {
        
    }
    public void invokerSet(long ChangeGradeSystemCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long ChangeGradeSystemCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long ChangeGradeSystemCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

