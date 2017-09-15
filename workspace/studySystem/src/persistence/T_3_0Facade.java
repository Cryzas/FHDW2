package persistence;

import model.*;

public class T_3_0Facade{



	public T_3_0Facade() {
	}

    public PersistentT_3_0 getTheT_3_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_3_0 result = new T_3_0(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_3_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 262);
    }
    
    public T_3_0 getT_3_0(long T_3_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

