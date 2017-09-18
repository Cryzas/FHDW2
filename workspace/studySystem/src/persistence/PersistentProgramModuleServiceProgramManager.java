package persistence;


public interface PersistentProgramModuleServiceProgramManager extends Anything, ObsInterface, AbstractPersistentProxi, ProgramModuleServiceProgramManager4Public {
    
    public ProgramModuleService4Public getObserver() throws PersistenceException ;
    public void setObserver(ProgramModuleService4Public newValue) throws PersistenceException ;
    public ProgramManager4Public getObservee() throws PersistenceException ;
    public void setObservee(ProgramManager4Public newValue) throws PersistenceException ;
    public PersistentProgramModuleServiceProgramManager getThis() throws PersistenceException ;
    
    

}

