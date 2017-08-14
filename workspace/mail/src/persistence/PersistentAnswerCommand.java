package persistence;


public interface PersistentAnswerCommand extends Anything, AccountManagerCommand, PersistentCommonDate, AbstractPersistentProxi, AnswerCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

