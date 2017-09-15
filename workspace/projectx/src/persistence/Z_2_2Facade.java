package persistence;

import model.*;

public class Z_2_2Facade{



	public Z_2_2Facade() {
	}

    public PersistentZ_2_2 getTheZ_2_2() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Z_2_2 result = new Z_2_2(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentZ_2_2)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 231);
    }
    
    public Z_2_2 getZ_2_2(long Z_2_2Id) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

