package persistence;


public interface PersistentChangeGradeCommand extends Anything, StudentManagerCommand, PersistentCommonDate, AbstractPersistentProxi, ChangeGradeCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

