package persistence;


public interface PersistentModuleAbstractSGroup extends programHierarchySGroupHIERARCHY, Anything, AbstractPersistentProxi, ModuleAbstractSGroup4Public {
    
    public void setModuleCopy(ModuleAbstract4Public newValue) throws PersistenceException ;
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException ;
    public abstract PersistentModuleAbstractSGroup getThis() throws PersistenceException ;
    
    

}

