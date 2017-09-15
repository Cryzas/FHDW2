package persistence;

import model.*;

public class T_1_0Facade{



	public T_1_0Facade() {
	}

    public PersistentT_1_0 getTheT_1_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_1_0 result = new T_1_0(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_1_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 221);
    }
    
    public T_1_0 getT_1_0(long T_1_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

