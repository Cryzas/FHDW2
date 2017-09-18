package persistence;


public interface PersistentServerAccounts extends Anything, ObsInterface, AbstractPersistentProxi, ServerAccounts4Public {
    
    public Server4Public getObserver() throws PersistenceException ;
    public void setObserver(Server4Public newValue) throws PersistenceException ;
    public AccountManager4Public getObservee() throws PersistenceException ;
    public void setObservee(AccountManager4Public newValue) throws PersistenceException ;
    public PersistentServerAccounts getThis() throws PersistenceException ;
    
    

}

