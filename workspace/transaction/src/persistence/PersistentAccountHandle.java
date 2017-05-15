package persistence;


public interface PersistentAccountHandle extends Anything, SubjInterface, AbstractPersistentProxi, AccountHandle4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentAccountHandle getThis() throws PersistenceException ;
    
    

}

