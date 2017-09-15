package persistence;

import model.*;

public class T_1_7Facade{



	public T_1_7Facade() {
	}

    public PersistentT_1_7 getTheT_1_7() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_1_7 result = new T_1_7(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_1_7)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 224);
    }
    
    public T_1_7 getT_1_7(long T_1_7Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

