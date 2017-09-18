package persistence;

import model.*;

public class Z_1_2Facade{



	public Z_1_2Facade() {
	}

    public PersistentZ_1_2 getTheZ_1_2() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_2 result = new Z_1_2(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_2)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 229);
    }
    
    public Z_1_2 getZ_1_2(long Z_1_2Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

