package persistence;

import model.*;

public class Z_2_1Facade{



	public Z_2_1Facade() {
	}

    public PersistentZ_2_1 getTheZ_2_1() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_1 result = new Z_2_1(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_1)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 242);
    }
    
    public Z_2_1 getZ_2_1(long Z_2_1Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

