package persistence;

import model.*;

public class NoProgramFacade{



	public NoProgramFacade() {
	}

    public PersistentNoProgram getTheNoProgram() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.getNextId();
        NoProgram result = new NoProgram(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentNoProgram)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 285);
    }
    
    public NoProgram getNoProgram(long NoProgramId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

