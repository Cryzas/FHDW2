package persistence;

import model.*;

public class Z_3_0Facade{



	public Z_3_0Facade() {
	}

    public PersistentZ_3_0 getTheZ_3_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_0 result = new Z_3_0(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 228);
    }
    
    public Z_3_0 getZ_3_0(long Z_3_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

