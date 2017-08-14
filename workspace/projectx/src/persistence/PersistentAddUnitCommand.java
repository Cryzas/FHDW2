package persistence;


public interface PersistentAddUnitCommand extends ModuleManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, AddUnitCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

