package persistence;


public interface PersistentMyBoolean extends Anything, SubjInterface, AbstractPersistentProxi, MyBoolean4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentMyBoolean getThis() throws PersistenceException ;
    
    

}

