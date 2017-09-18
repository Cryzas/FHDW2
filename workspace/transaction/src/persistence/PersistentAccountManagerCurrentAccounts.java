package persistence;


public interface PersistentAccountManagerCurrentAccounts extends PersistentListProxiInterface<AccountHandle4Public>, Anything, ObsInterface, AbstractPersistentProxi, AccountManagerCurrentAccounts4Public {
    
    public AccountManager4Public getObserver() throws PersistenceException ;
    public void setObserver(AccountManager4Public newValue) throws PersistenceException ;
    public PersistentAccountManagerCurrentAccounts getThis() throws PersistenceException ;
    
    

}

