package persistence;

import model.*;

public class Z_2_6Facade{



	public Z_2_6Facade() {
	}

    public PersistentZ_2_6 getTheZ_2_6() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_6 result = new Z_2_6(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_6)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 235);
    }
    
    public Z_2_6 getZ_2_6(long Z_2_6Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

