package persistence;


public interface PersistentStartStudyGroupCommand extends Anything, ProgramManagerCommand, PersistentCommonDate, AbstractPersistentProxi, StartStudyGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

