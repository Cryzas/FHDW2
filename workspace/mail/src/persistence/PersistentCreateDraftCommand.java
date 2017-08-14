package persistence;


public interface PersistentCreateDraftCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateDraftCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

