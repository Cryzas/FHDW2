package persistence;


public interface PersistentCreateProductCommand extends PartsListManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateProductCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

