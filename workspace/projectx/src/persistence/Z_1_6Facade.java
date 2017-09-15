package persistence;

import model.*;

public class Z_1_6Facade{



	public Z_1_6Facade() {
	}

    public PersistentZ_1_6 getTheZ_1_6() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_6 result = new Z_1_6(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_6)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 251);
    }
    
    public Z_1_6 getZ_1_6(long Z_1_6Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

