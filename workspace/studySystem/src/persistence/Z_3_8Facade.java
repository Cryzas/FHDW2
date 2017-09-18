package persistence;

import model.*;

public class Z_3_8Facade{



	public Z_3_8Facade() {
	}

    public PersistentZ_3_8 getTheZ_3_8() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_3_8 result = new Z_3_8(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_3_8)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 258);
    }
    
    public Z_3_8 getZ_3_8(long Z_3_8Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

