package persistence;


public interface PersistentCreateFolderCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateFolderCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

