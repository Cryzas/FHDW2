package persistence;

import model.*;

public class NoGradeFacade{



	public NoGradeFacade() {
	}

    public PersistentNoGrade getTheNoGrade() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        NoGrade result = new NoGrade(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentNoGrade)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 273);
    }
    
    public NoGrade getNoGrade(long NoGradeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

