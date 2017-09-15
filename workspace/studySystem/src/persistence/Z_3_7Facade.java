package persistence;

import model.*;

public class Z_3_7Facade{



	public Z_3_7Facade() {
	}

    public PersistentZ_3_7 getTheZ_3_7() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_7 result = new Z_3_7(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_7)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 256);
    }
    
    public Z_3_7 getZ_3_7(long Z_3_7Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

