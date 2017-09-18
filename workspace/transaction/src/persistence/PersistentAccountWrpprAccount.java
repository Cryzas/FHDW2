package persistence;


public interface PersistentAccountWrpprAccount extends Anything, ObsInterface, AbstractPersistentProxi, AccountWrpprAccount4Public {
    
    public AccountWrppr4Public getObserver() throws PersistenceException ;
    public void setObserver(AccountWrppr4Public newValue) throws PersistenceException ;
    public Account4Public getObservee() throws PersistenceException ;
    public void setObservee(Account4Public newValue) throws PersistenceException ;
    public PersistentAccountWrpprAccount getThis() throws PersistenceException ;
    
    

}

