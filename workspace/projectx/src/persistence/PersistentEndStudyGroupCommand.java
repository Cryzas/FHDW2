package persistence;


public interface PersistentEndStudyGroupCommand extends StudyGroupManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, EndStudyGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

