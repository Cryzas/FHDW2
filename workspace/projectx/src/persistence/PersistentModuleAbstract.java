package persistence;


public interface PersistentModuleAbstract extends Anything, SubjInterface, AbstractPersistentProxi, ModuleAbstract4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentModuleAbstract getThis() throws PersistenceException ;
    
    

}

