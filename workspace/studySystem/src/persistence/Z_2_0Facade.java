package persistence;

import model.*;

public class Z_2_0Facade{



	public Z_2_0Facade() {
	}

    public PersistentZ_2_0 getTheZ_2_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_0 result = new Z_2_0(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 241);
    }
    
    public Z_2_0 getZ_2_0(long Z_2_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

