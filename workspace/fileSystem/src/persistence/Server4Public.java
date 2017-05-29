package persistence;


import model.visitor.*;

public interface Server4Public extends Invoker, Anything, Remote, AbstractPersistentProxi {
    
    public String getUser() throws PersistenceException ;
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public FileSystem4Public getSystemRoot() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public String server_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void changeContents(final File4Public file, final String contents) 
				throws PersistenceException;
    public void clip(final Containee4Public containee) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void create(final Directory4Public container, final String name, final String type) 
				throws PersistenceException;
    public void delete(final Containee4Public containee) 
				throws PersistenceException;
    public FileSystem4Public getSystemRoot(final TDObserver observer) 
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
    public void paste(final Directory4Public directory) 
				throws model.FileSystemException, PersistenceException;

}

