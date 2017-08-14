package persistence;


public interface PersistentCreateModuleCommand extends ModuleManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateModuleCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

