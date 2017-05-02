package persistence;


public interface PersistentAddPartCommand extends Anything, ProductCommand, PersistentCommonDate, AbstractPersistentProxi, AddPartCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

