package persistence;


public interface PersistentAddTransferCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, AddTransferCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

