package persistence;


public interface PersistentCreateMaterialCommand extends PartsListManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateMaterialCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

