package persistence;

import model.*;

public class ServerFacade{

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

	

	public ServerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServer newServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentServer)PersistentProxi.createProxi(idCreateIfLessZero, -102);
        long id = ConnectionHandler.getTheConnectionHandler().theServerFacade.getNextId();
        Server result = new Server(null,null,null,password,user,hackCount,hackDelay,id);
        Cache.getTheCache().put(result);
        return (PersistentServer)PersistentProxi.createProxi(id, -102);
    }
    
    public PersistentServer newDelayedServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServerFacade.getNextId();
        Server result = new Server(null,null,null,password,user,hackCount,hackDelay,id);
        Cache.getTheCache().put(result);
        return (PersistentServer)PersistentProxi.createProxi(id, -102);
    }
    
    public Server getServer(long ServerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -102)) return -102;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ServerSearchList getServerByUser(String user) throws PersistenceException {
        user = user.replaceAll("\\\\", "\\\\\\\\");
        user = user.replaceAll("\\?", "\\\\?");
        user = user.replaceAll("\\+", "\\\\+");
        user = user.replaceAll("\\*", "\\\\*");
        user = user.replaceAll("\\[", "\\\\[");
        user = user.replaceAll("\\]", "\\\\]");
        user = user.replaceAll("\\{", "\\\\{");
        user = user.replaceAll("\\}", "\\\\}");
        user = user.replaceAll("\\&", "\\\\&");
        user = user.replaceAll("\\-", "\\\\-");
        user = user.replaceAll("@@", "@-");
        user = user.replaceAll("%", "%-");
        user = user.replaceAll("_", "_-");
        user = user.replaceAll("@_-", "_");
        user = user.replaceAll("@%-", "%");
        user = user.replaceAll("@-", "@");
        user = user.replaceAll("%-", ".*");
        user = user.replaceAll("_-", ".");
        ServerSearchList result = new ServerSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(-102);
        while (candidates.hasNext()){
            PersistentServer current = (PersistentServer)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getUser().matches(user))
                result.add((PersistentServer)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void serviceSet(long ServerId, Service4Public serviceVal) throws PersistenceException {
        
    }
    public void subServiceSet(long ServerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ServerId, Server4Public ThisVal) throws PersistenceException {
        
    }
    public void passwordSet(long ServerId, String passwordVal) throws PersistenceException {
        
    }
    public void userSet(long ServerId, String userVal) throws PersistenceException {
        
    }
    public void hackCountSet(long ServerId, long hackCountVal) throws PersistenceException {
        
    }
    public void hackDelaySet(long ServerId, java.sql.Timestamp hackDelayVal) throws PersistenceException {
        
    }
    public ServerSearchList inverseGetService(long objectId, long classId)throws PersistenceException{
        ServerSearchList result = new ServerSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(-102);
        while (candidates.hasNext()){
            PersistentServer current = (PersistentServer)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getService() != null){
                if (current.getService().getClassId() == classId && current.getService().getId() == objectId) {
                    PersistentServer proxi = (PersistentServer)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentServer)proxi.getThis());
                }
            }
        }
        return result;
    }

}

