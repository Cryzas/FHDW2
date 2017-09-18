package persistence;


public interface PersistentWrapperRecycle extends Anything, SubjInterface, AbstractPersistentProxi, WrapperRecycle4Public {
    
    public WrapperRecycle_RecycledProxi getRecycled() throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentWrapperRecycle getThis() throws PersistenceException ;
    
    

}

