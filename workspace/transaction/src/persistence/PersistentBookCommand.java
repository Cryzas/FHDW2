package persistence;


public interface PersistentBookCommand extends TransferManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, BookCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

