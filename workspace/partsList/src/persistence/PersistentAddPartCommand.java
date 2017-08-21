package persistence;


public interface PersistentAddPartCommand extends Anything, ProductCommand, PersistentCommonDate, AbstractPersistentProxi, AddPartCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

