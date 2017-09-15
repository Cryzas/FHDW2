package persistence;

import model.*;

public class BTrueFacade{



	public BTrueFacade() {
	}

    public PersistentBTrue getTheBTrue() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMyBooleanFacade.getNextId();
        BTrue result = new BTrue(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentBTrue)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 281);
    }
    
    public BTrue getBTrue(long BTrueId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

