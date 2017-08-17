package persistence;


public interface PersistentStudentManager extends Anything, AbstractPersistentProxi, StudentManager4Public {
    
    public PersistentStudentManager getThis() throws PersistenceException ;
    
    

}

