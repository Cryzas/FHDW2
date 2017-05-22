package persistence;


public interface PersistentService extends Invoker, Anything, Remote, AbstractPersistentProxi, Service4Public {
    
    public Service_ErrorsProxi getErrors() throws PersistenceException ;
    public abstract PersistentService getThis() throws PersistenceException ;
    
    

}

