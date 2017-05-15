package persistence;


public interface PersistentAbstractTransfer extends Anything, SubjInterface, AbstractPersistentProxi, AbstractTransfer4Public {
    
    public void setSubject(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentAbstractTransfer getThis() throws PersistenceException ;
    
    

}

