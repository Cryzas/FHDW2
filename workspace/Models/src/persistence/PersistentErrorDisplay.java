package persistence;


public interface PersistentErrorDisplay extends Anything, AbstractPersistentProxi, ErrorDisplay4Public {
    
    public String getMessage() throws PersistenceException ;
    public void setMessage(String newValue) throws PersistenceException ;
    public PersistentErrorDisplay getThis() throws PersistenceException ;
    
    

}

