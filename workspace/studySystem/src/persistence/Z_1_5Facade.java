package persistence;

import model.*;

public class Z_1_5Facade{



	public Z_1_5Facade() {
	}

    public PersistentZ_1_5 getTheZ_1_5() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_5 result = new Z_1_5(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_5)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 249);
    }
    
    public Z_1_5 getZ_1_5(long Z_1_5Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

