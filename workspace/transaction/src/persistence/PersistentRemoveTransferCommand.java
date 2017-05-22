package persistence;


public interface PersistentRemoveTransferCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, RemoveTransferCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

