package persistence;

import model.*;

public class T_4_0Facade{



	public T_4_0Facade() {
	}

    public PersistentT_4_0 getTheT_4_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_4_0 result = new T_4_0(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_4_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 239);
    }
    
    public T_4_0 getT_4_0(long T_4_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

