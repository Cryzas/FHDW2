package persistence;


public interface PersistentCreateFolderCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateFolderCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

