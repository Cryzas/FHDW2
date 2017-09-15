package persistence;

import model.*;

public class Z_1_1Facade{



	public Z_1_1Facade() {
	}

    public PersistentZ_1_1 getTheZ_1_1() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_1 result = new Z_1_1(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_1)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 227);
    }
    
    public Z_1_1 getZ_1_1(long Z_1_1Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

