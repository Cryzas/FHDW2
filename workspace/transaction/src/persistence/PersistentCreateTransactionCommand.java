package persistence;


public interface PersistentCreateTransactionCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateTransactionCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

