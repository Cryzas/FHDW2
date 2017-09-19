package persistence;

import model.*;

public class T_5_0Facade{



	public T_5_0Facade() {
	}

    public PersistentT_5_0 getTheT_5_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_5_0 result = new T_5_0(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_5_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 261);
    }
    
    public T_5_0 getT_5_0(long T_5_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

