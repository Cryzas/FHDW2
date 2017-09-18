package persistence;


public interface PersistentAccountManager extends Anything, SubjInterface, AbstractPersistentProxi, AccountManager4Public {
    
    public void setCurrentAccounts(AccountManagerCurrentAccounts4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentAccountManager getThis() throws PersistenceException ;
    
    
    public void currentAccounts_update(final model.meta.AccountHandleMssgs event) 
				throws PersistenceException;

}

