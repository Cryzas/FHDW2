package persistence;


public interface PersistentAnswerAllCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, AnswerAllCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

