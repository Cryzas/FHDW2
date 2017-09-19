package persistence;

import model.*;

public class Z_2_5Facade{



	public Z_2_5Facade() {
	}

    public PersistentZ_2_5 getTheZ_2_5() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_5 result = new Z_2_5(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_5)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 234);
    }
    
    public Z_2_5 getZ_2_5(long Z_2_5Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

