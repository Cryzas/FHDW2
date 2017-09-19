package persistence;

import model.*;

public class Z_5_0Facade{



	public Z_5_0Facade() {
	}

    public PersistentZ_5_0 getTheZ_5_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_5_0 result = new Z_5_0(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_5_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 245);
    }
    
    public Z_5_0 getZ_5_0(long Z_5_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

