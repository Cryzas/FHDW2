package persistence;

import model.*;

public class UserManagerServiceFacade{



	public UserManagerServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUserManagerService newUserManagerService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentUserManagerService)PersistentProxi.createProxi(idCreateIfLessZero, -290);
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        UserManagerService result = new UserManagerService(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUserManagerService)PersistentProxi.createProxi(id, -290);
    }
    
    public PersistentUserManagerService newDelayedUserManagerService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        UserManagerService result = new UserManagerService(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentUserManagerService)PersistentProxi.createProxi(id, -290);
    }
    
    public UserManagerService getUserManagerService(long UserManagerServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long usersAdd(long UserManagerServiceId, Server4Public usersVal) throws PersistenceException {
        return 0;
    }
    public void usersRem(long usersId) throws PersistenceException {
        
    }
    public ServerList usersGet(long UserManagerServiceId) throws PersistenceException {
        return new ServerList(); // remote access for initialization only!
    }

}

