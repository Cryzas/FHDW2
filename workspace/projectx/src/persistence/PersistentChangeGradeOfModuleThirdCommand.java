package persistence;


public interface PersistentChangeGradeOfModuleThirdCommand extends Anything, StudentManagerCommand, PersistentCommonDate, AbstractPersistentProxi, ChangeGradeOfModuleThirdCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

