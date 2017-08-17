package persistence;


public interface PersistentModuleAbstract extends Anything, programHierarchyHIERARCHY, AbstractPersistentProxi, ModuleAbstract4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setGradeSystem(GradeSystem4Public newValue) throws PersistenceException ;
    public abstract PersistentModuleAbstract getThis() throws PersistenceException ;
    
    

}

