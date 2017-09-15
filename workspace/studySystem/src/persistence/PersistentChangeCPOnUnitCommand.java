package persistence;


public interface PersistentChangeCPOnUnitCommand extends ModuleManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, ChangeCPOnUnitCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

