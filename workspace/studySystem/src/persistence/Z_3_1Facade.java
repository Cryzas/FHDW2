package persistence;

import model.*;

public class Z_3_1Facade{



	public Z_3_1Facade() {
	}

    public PersistentZ_3_1 getTheZ_3_1() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_1 result = new Z_3_1(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_1)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 243);
    }
    
    public Z_3_1 getZ_3_1(long Z_3_1Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

