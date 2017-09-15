package persistence;


public interface PersistentChangeCPOnModuleCommand extends ModuleManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, ChangeCPOnModuleCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

