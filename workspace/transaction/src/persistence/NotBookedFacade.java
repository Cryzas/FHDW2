package persistence;

import model.*;

public class NotBookedFacade{



	public NotBookedFacade() {
	}

    public PersistentNotBooked getTheNotBooked() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTransferStateFacade.getNextId();
        NotBooked result = new NotBooked(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentNotBooked)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 138);
    }
    
    public NotBooked getNotBooked(long NotBookedId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

