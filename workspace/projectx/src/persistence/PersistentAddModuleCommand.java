package persistence;


public interface PersistentAddModuleCommand extends Anything, ProgramManagerCommand, PersistentCommonDate, AbstractPersistentProxi, AddModuleCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

