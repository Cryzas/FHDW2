package persistence;


public interface PersistentChangeGradeOfUnitCommand extends Anything, StudentManagerCommand, PersistentCommonDate, AbstractPersistentProxi, ChangeGradeOfUnitCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

