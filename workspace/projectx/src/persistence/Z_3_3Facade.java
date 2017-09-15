package persistence;

import model.*;

public class Z_3_3Facade{



	public Z_3_3Facade() {
	}

    public PersistentZ_3_3 getTheZ_3_3() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_3 result = new Z_3_3(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_3)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 248);
    }
    
    public Z_3_3 getZ_3_3(long Z_3_3Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

