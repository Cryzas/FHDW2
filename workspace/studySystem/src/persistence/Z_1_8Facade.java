package persistence;

import model.*;

public class Z_1_8Facade{



	public Z_1_8Facade() {
	}

    public PersistentZ_1_8 getTheZ_1_8() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_1_8 result = new Z_1_8(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_1_8)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 255);
    }
    
    public Z_1_8 getZ_1_8(long Z_1_8Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

