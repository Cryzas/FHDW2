package persistence;


public interface PersistentCreateAccountCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateAccountCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

