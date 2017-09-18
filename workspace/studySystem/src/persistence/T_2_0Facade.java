package persistence;

import model.*;

public class T_2_0Facade{



	public T_2_0Facade() {
	}

    public PersistentT_2_0 getTheT_2_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_2_0 result = new T_2_0(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_2_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 223);
    }
    
    public T_2_0 getT_2_0(long T_2_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

