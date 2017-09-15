package persistence;

import model.*;

public class T_3_3Facade{



	public T_3_3Facade() {
	}

    public PersistentT_3_3 getTheT_3_3() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_3_3 result = new T_3_3(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_3_3)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 263);
    }
    
    public T_3_3 getT_3_3(long T_3_3Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

