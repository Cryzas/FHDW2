package persistence;


public interface PersistentChangeContentsCommand extends FileCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, ChangeContentsCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

