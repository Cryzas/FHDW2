package persistence;


public interface PersistentCreateTransferCommand extends Anything, ManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateTransferCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

