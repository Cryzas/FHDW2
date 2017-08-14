package persistence;


public interface PersistentAddReceiverCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, AddReceiverCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

