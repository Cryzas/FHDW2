package persistence;

import model.*;

public class Z_2_8Facade{



	public Z_2_8Facade() {
	}

    public PersistentZ_2_8 getTheZ_2_8() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_8 result = new Z_2_8(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_8)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 237);
    }
    
    public Z_2_8 getZ_2_8(long Z_2_8Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

