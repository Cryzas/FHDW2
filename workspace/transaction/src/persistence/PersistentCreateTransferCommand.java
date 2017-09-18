package persistence;


public interface PersistentCreateTransferCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateTransferCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

