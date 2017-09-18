package persistence;


public interface PersistentProgramModuleService extends PersistentsubAdminService, ProgramModuleService4Public {
    
    public void setProgramManager(ProgramModuleServiceProgramManager4Public newValue) throws PersistenceException ;
    public void setModuleManager(ProgramModuleServiceModuleManager4Public newValue) throws PersistenceException ;
    public PersistentProgramModuleService getThis() throws PersistenceException ;
    
    
    public void setModuleManager(final ModuleManager4Public moduleManager) 
				throws PersistenceException;
    public void setProgramManager(final ProgramManager4Public programManager) 
				throws PersistenceException;
    public void moduleManager_update(final model.meta.ModuleManagerMssgs event) 
				throws PersistenceException;
    public void programManager_update(final model.meta.ProgramManagerMssgs event) 
				throws PersistenceException;

}

