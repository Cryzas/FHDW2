package persistence;


public interface PersistentAddModuleToProgCommand extends Anything, ProgramManagerCommand, PersistentCommonDate, AbstractPersistentProxi, AddModuleToProgCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

