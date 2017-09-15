package persistence;


public interface PersistentStudentService extends PersistentService, StudentService4Public {
    
    public PersistentStudentService getThis() throws PersistenceException ;
    
    

}

