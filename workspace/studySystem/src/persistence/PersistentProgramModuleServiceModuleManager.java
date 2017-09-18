package persistence;


public interface PersistentProgramModuleServiceModuleManager extends Anything, ObsInterface, AbstractPersistentProxi, ProgramModuleServiceModuleManager4Public {
    
    public ProgramModuleService4Public getObserver() throws PersistenceException ;
    public void setObserver(ProgramModuleService4Public newValue) throws PersistenceException ;
    public ModuleManager4Public getObservee() throws PersistenceException ;
    public void setObservee(ModuleManager4Public newValue) throws PersistenceException ;
    public PersistentProgramModuleServiceModuleManager getThis() throws PersistenceException ;
    
    

}

