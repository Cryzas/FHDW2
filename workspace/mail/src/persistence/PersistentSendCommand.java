package persistence;


public interface PersistentSendCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, SendCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

