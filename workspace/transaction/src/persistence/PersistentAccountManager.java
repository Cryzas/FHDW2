package persistence;


public interface PersistentAccountManager extends Anything, SubjInterface, AbstractPersistentProxi, AccountManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentAccountManager getThis() throws PersistenceException ;
    
    

}

