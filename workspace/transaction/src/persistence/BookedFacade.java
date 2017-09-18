package persistence;

import model.*;

public class BookedFacade{



	public BookedFacade() {
	}

    public PersistentBooked getTheBooked() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTransferStateFacade.getNextId();
        Booked result = new Booked(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentBooked)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 137);
    }
    
    public Booked getBooked(long BookedId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

