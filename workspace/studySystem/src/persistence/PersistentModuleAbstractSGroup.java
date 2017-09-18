package persistence;


public interface PersistentModuleAbstractSGroup extends programHierarchySGroupHIERARCHY, Anything, SubjInterface, AbstractPersistentProxi, ModuleAbstractSGroup4Public {
    
    public void setModuleCopy(ModuleAbstract4Public newValue) throws PersistenceException ;
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentModuleAbstractSGroup getThis() throws PersistenceException ;
    
    

}

