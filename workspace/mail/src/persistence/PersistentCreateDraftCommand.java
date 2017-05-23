package persistence;


public interface PersistentCreateDraftCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateDraftCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

