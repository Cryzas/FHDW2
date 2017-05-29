package persistence;


public interface PersistentAddContaineeCommand extends Anything, DirectoryCommand, PersistentCommonDate, AbstractPersistentProxi, AddContaineeCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

