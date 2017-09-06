package persistence;


public interface PersistentChangeGradeOfModuleCommand extends Anything, StudentManagerCommand, PersistentCommonDate, AbstractPersistentProxi, ChangeGradeOfModuleCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

