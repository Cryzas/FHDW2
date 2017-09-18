package persistence;


public interface PersistentStudent extends Anything, SubjInterface, AbstractPersistentProxi, Student4Public {
    
    public void setFirstName(String newValue) throws PersistenceException ;
    public void setLastName(String newValue) throws PersistenceException ;
    public void setBirthDate(java.sql.Date newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentStudent getThis() throws PersistenceException ;
    
    

}

