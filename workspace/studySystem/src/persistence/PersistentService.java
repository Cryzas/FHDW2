package persistence;


public interface PersistentService extends Invoker, Anything, SubjInterface, Remote, AbstractPersistentProxi, Service4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public Service_ErrorsProxi getErrors() throws PersistenceException ;
    public abstract PersistentService getThis() throws PersistenceException ;
    
    
    public ServerSearchList getParentServer() 
				throws PersistenceException;

}

