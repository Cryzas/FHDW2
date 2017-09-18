package persistence;


public interface PersistentStudentManager extends Anything, SubjInterface, AbstractPersistentProxi, StudentManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentStudentManager getThis() throws PersistenceException ;
    
    

}

