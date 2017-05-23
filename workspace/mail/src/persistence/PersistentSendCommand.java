package persistence;


public interface PersistentSendCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, SendCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

