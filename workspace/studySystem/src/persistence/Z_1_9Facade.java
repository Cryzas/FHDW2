package persistence;

import model.*;

public class Z_1_9Facade{



	public Z_1_9Facade() {
	}

    public PersistentZ_1_9 getTheZ_1_9() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_9 result = new Z_1_9(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_9)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 257);
    }
    
    public Z_1_9 getZ_1_9(long Z_1_9Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

