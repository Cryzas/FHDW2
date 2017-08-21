package persistence;


public interface PersistentCreateProductCommand extends PartsListManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateProductCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

