package persistence;

import model.*;

public class T_1_3Facade{



	public T_1_3Facade() {
	}

    public PersistentT_1_3 getTheT_1_3() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_1_3 result = new T_1_3(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_1_3)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 220);
    }
    
    public T_1_3 getT_1_3(long T_1_3Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

