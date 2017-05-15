package persistence;


public interface PersistentBookCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, BookCommand4Public {
    
    public CommonDate4Public getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException ;
    
    

}

