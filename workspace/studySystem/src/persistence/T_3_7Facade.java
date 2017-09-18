package persistence;

import model.*;

public class T_3_7Facade{



	public T_3_7Facade() {
	}

    public PersistentT_3_7 getTheT_3_7() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_3_7 result = new T_3_7(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_3_7)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 225);
    }
    
    public T_3_7 getT_3_7(long T_3_7Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

