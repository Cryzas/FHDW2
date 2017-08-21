package persistence;


public interface PersistentCreateMaterialCommand extends PartsListManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateMaterialCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

