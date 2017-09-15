package persistence;

import model.*;

public class Z_1_3Facade{



	public Z_1_3Facade() {
	}

    public PersistentZ_1_3 getTheZ_1_3() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_3 result = new Z_1_3(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_3)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 244);
    }
    
    public Z_1_3 getZ_1_3(long Z_1_3Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

