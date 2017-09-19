package persistence;

import model.*;

public class Z_1_4Facade{



	public Z_1_4Facade() {
	}

    public PersistentZ_1_4 getTheZ_1_4() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_4 result = new Z_1_4(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_4)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 247);
    }
    
    public Z_1_4 getZ_1_4(long Z_1_4Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

