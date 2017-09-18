package persistence;


public interface PersistentAccountWrppr extends PersistentAccountHandle, AccountWrppr4Public {
    
    public void setAccount(AccountWrpprAccount4Public newValue) throws PersistenceException ;
    public PersistentAccountWrppr getThis() throws PersistenceException ;
    
    
    public void account_update(final model.meta.AccountMssgs event) 
				throws PersistenceException;

}

