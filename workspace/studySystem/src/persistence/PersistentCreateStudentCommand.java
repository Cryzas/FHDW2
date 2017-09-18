package persistence;


public interface PersistentCreateStudentCommand extends StudyGroupManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, CreateStudentCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

