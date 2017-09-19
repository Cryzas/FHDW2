package persistence;

import model.*;

public class StudentManageServiceFacade{



	public StudentManageServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentManageService newStudentManageService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudentManageService)PersistentProxi.createProxi(idCreateIfLessZero, -303);
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        StudentManageService result = new StudentManageService(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentManageService)PersistentProxi.createProxi(id, -303);
    }
    
    public PersistentStudentManageService newDelayedStudentManageService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        StudentManageService result = new StudentManageService(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudentManageService)PersistentProxi.createProxi(id, -303);
    }
    
    public StudentManageService getStudentManageService(long StudentManageServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void studentManagerSet(long StudentManageServiceId, StudentManageServiceStudentManager4Public studentManagerVal) throws PersistenceException {
        
    }

}

