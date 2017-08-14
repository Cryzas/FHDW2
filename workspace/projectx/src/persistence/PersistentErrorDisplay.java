package persistence;


public interface PersistentErrorDisplay extends Anything, SubjInterface, AbstractPersistentProxi, ErrorDisplay4Public {
    
    public String getMessage() throws PersistenceException ;
    public void setMessage(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentErrorDisplay getThis() throws PersistenceException ;
    
    

}

