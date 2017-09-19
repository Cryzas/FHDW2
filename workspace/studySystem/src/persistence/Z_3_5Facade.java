package persistence;

import model.*;

public class Z_3_5Facade{



	public Z_3_5Facade() {
	}

    public PersistentZ_3_5 getTheZ_3_5() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_5 result = new Z_3_5(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_5)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 252);
    }
    
    public Z_3_5 getZ_3_5(long Z_3_5Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

