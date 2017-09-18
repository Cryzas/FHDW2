package persistence;

import model.*;

public class T_2_3Facade{



	public T_2_3Facade() {
	}

    public PersistentT_2_3 getTheT_2_3() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_2_3 result = new T_2_3(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_2_3)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 222);
    }
    
    public T_2_3 getT_2_3(long T_2_3Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

