package persistence;


public interface PersistentCreateAccountCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateAccountCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

