package persistence;

import model.*;

public class Z_1_7Facade{



	public Z_1_7Facade() {
	}

    public PersistentZ_1_7 getTheZ_1_7() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_7 result = new Z_1_7(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_7)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 253);
    }
    
    public Z_1_7 getZ_1_7(long Z_1_7Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

