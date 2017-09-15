package persistence;

import model.meta.*;

public class CommandCoordinatorFacade{

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

	

	public CommandCoordinatorFacade() {
	}

    public PersistentCommandCoordinator getTheCommandCoordinator() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade.getNextId();
        CommandCoordinator result = new CommandCoordinator(id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentCommandCoordinator)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), -101);
    }
    
    public CommandCoordinator getCommandCoordinator(long CommandCoordinatorId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -101)) return -101;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long executerAdd(long CommandCoordinatorId, CommandExecuter4Public executerVal) throws PersistenceException {
        return 0;
    }
    public void executerRem(long executerId) throws PersistenceException {
        
    }
    public CommandExecuterList executerGet(long CommandCoordinatorId) throws PersistenceException {
        return new CommandExecuterList(); // remote access for initialization only!
    }

}

