package persistence;

import model.*;

public class Z_4_0Facade{



	public Z_4_0Facade() {
	}

    public PersistentZ_4_0 getTheZ_4_0() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_4_0 result = new Z_4_0(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_4_0)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 230);
    }
    
    public Z_4_0 getZ_4_0(long Z_4_0Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

