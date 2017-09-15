package persistence;

import model.*;

public class Z_2_7Facade{



	public Z_2_7Facade() {
	}

    public PersistentZ_2_7 getTheZ_2_7() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_7 result = new Z_2_7(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_7)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 236);
    }
    
    public Z_2_7 getZ_2_7(long Z_2_7Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

