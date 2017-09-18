package persistence;


import model.visitor.*;

public interface subAdminService4Public extends Invoker, Anything, SubjInterface, Remote, AbstractPersistentProxi {
    
    public AdminService4Public getParentService() throws PersistenceException ;
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void updatePLZ() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException;
    public void updateMe() 
				throws PersistenceException;
    public void updatePLZImplementation() 
				throws PersistenceException;

}

