package persistence;


public interface PersistentChangeGradeSystemCommand extends ModuleManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, ChangeGradeSystemCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

