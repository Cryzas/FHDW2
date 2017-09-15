package persistence;

import model.meta.*;

public class CommandExecuterFacade{

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

	

	public CommandExecuterFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCommandExecuter newCommandExecuter(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCommandExecuter)PersistentProxi.createProxi(idCreateIfLessZero, -105);
        long id = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getNextId();
        CommandExecuter result = new CommandExecuter(id);
        Cache.getTheCache().put(result);
        return (PersistentCommandExecuter)PersistentProxi.createProxi(id, -105);
    }
    
    public PersistentCommandExecuter newDelayedCommandExecuter() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getNextId();
        CommandExecuter result = new CommandExecuter(id);
        Cache.getTheCache().put(result);
        return (PersistentCommandExecuter)PersistentProxi.createProxi(id, -105);
    }
    
    public CommandExecuter getCommandExecuter(long CommandExecuterId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -105)) return -105;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long commandsAdd(long CommandExecuterId, Command commandsVal) throws PersistenceException {
        return 0;
    }
    public void commandsRem(long commandsId) throws PersistenceException {
        
    }
    public CommandList commandsGet(long CommandExecuterId) throws PersistenceException {
        return new CommandList(); // remote access for initialization only!
    }

}

