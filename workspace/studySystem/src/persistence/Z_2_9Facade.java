package persistence;

import model.*;

public class Z_2_9Facade{



	public Z_2_9Facade() {
	}

    public PersistentZ_2_9 getTheZ_2_9() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_9 result = new Z_2_9(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_9)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 238);
    }
    
    public Z_2_9 getZ_2_9(long Z_2_9Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

