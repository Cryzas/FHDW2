package persistence;


public interface PersistentSwapCPonModuleWithUnitsCommand extends StudyGroupManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, SwapCPonModuleWithUnitsCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

