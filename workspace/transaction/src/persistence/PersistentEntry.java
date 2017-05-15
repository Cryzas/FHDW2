package persistence;


public interface PersistentEntry extends Anything, SubjInterface, AbstractPersistentProxi, Entry4Public {
    
    public void setTransfer(Transfer4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentEntry getThis() throws PersistenceException ;
    
    

}

