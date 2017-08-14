package persistence;


public interface PersistentCreateProgramCommand extends Anything, ProgramManagerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateProgramCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

