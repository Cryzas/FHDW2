package persistence;


public interface PersistentCreateTransferCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateTransferCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

