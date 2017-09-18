package persistence;

import model.*;

public class Z_2_3Facade{



	public Z_2_3Facade() {
	}

    public PersistentZ_2_3 getTheZ_2_3() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_3 result = new Z_2_3(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_3)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 232);
    }
    
    public Z_2_3 getZ_2_3(long Z_2_3Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

