package persistence;

import model.*;

public class Z_3_9Facade{



	public Z_3_9Facade() {
	}

    public PersistentZ_3_9 getTheZ_3_9() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_9 result = new Z_3_9(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_9)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 259);
    }
    
    public Z_3_9 getZ_3_9(long Z_3_9Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

