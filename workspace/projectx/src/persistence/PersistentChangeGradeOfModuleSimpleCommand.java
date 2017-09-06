package persistence;


public interface PersistentChangeGradeOfModuleSimpleCommand extends Anything, StudentManagerCommand, PersistentCommonDate, AbstractPersistentProxi, ChangeGradeOfModuleSimpleCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

