package persistence;

import model.*;

public class Z_3_4Facade{



	public Z_3_4Facade() {
	}

    public PersistentZ_3_4 getTheZ_3_4() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_4 result = new Z_3_4(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_4)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 250);
    }
    
    public Z_3_4 getZ_3_4(long Z_3_4Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

