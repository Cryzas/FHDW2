package persistence;


public interface PersistentAddStudentToGroupCommand extends StudyGroupManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, AddStudentToGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

