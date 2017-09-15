package persistence;

import model.*;

public class T_2_7Facade{



	public T_2_7Facade() {
	}

    public PersistentT_2_7 getTheT_2_7() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        T_2_7 result = new T_2_7(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentT_2_7)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 240);
    }
    
    public T_2_7 getT_2_7(long T_2_7Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

