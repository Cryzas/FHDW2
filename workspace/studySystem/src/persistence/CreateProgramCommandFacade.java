package persistence;

import model.meta.*;

public class CreateProgramCommandFacade{

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

	

	public CreateProgramCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateProgramCommand newCreateProgramCommand(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCreateProgramCommand)PersistentProxi.createProxi(idCreateIfLessZero, 155);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateProgramCommandFacade.getNextId();
        CreateProgramCommand result = new CreateProgramCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateProgramCommand)PersistentProxi.createProxi(id, 155);
    }
    
    public PersistentCreateProgramCommand newDelayedCreateProgramCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateProgramCommandFacade.getNextId();
        CreateProgramCommand result = new CreateProgramCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateProgramCommand)PersistentProxi.createProxi(id, 155);
    }
    
    public CreateProgramCommand getCreateProgramCommand(long CreateProgramCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 155)) return 155;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateProgramCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateProgramCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateProgramCommandId, ProgramManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateProgramCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

