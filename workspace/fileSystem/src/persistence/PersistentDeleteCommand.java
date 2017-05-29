package persistence;


public interface PersistentDeleteCommand extends Anything, ContaineeCommand, PersistentCommonDate, AbstractPersistentProxi, DeleteCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

