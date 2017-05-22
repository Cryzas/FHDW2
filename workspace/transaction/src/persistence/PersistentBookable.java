package persistence;


public interface PersistentBookable extends Anything, SubjInterface, AbstractPersistentProxi, Bookable4Public {
    
    public void setSubject(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentBookable getThis() throws PersistenceException ;
    
    

}

