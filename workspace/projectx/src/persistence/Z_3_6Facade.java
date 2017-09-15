package persistence;

import model.*;

public class Z_3_6Facade{



	public Z_3_6Facade() {
	}

    public PersistentZ_3_6 getTheZ_3_6() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_6 result = new Z_3_6(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_6)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 254);
    }
    
    public Z_3_6 getZ_3_6(long Z_3_6Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

