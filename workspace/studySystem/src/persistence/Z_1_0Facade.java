package persistence;

import model.*;

public class Z_1_0Facade{



	public Z_1_0Facade() {
	}

    public PersistentZ_1_0 getTheZ_1_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_0 result = new Z_1_0(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 226);
    }
    
    public Z_1_0 getZ_1_0(long Z_1_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

