package persistence;

import model.*;

public class Z_3_2Facade{



	public Z_3_2Facade() {
	}

    public PersistentZ_3_2 getTheZ_3_2() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_2 result = new Z_3_2(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_2)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 246);
    }
    
    public Z_3_2 getZ_3_2(long Z_3_2Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

