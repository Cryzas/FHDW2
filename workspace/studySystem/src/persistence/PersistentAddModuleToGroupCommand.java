package persistence;


public interface PersistentAddModuleToGroupCommand extends ModuleManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, AddModuleToGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

