package persistence;


public interface PersistentModuleManager extends Anything, SubjInterface, AbstractPersistentProxi, ModuleManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentModuleManager getThis() throws PersistenceException ;
    
    

}

