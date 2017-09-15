package persistence;

import model.*;

public class Z_2_4Facade{



	public Z_2_4Facade() {
	}

    public PersistentZ_2_4 getTheZ_2_4() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_4 result = new Z_2_4(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_4)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 233);
    }
    
    public Z_2_4 getZ_2_4(long Z_2_4Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

