package persistence;

import model.*;

public class StudentServiceFacade{



	public StudentServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentService newStudentService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudentService)PersistentProxi.createProxi(idCreateIfLessZero, -286);
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        StudentService result = new StudentService(null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentService)PersistentProxi.createProxi(id, -286);
    }
    
    public PersistentStudentService newDelayedStudentService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        StudentService result = new StudentService(null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentService)PersistentProxi.createProxi(id, -286);
    }
    
    public StudentService getStudentService(long StudentServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

