package persistence;


import model.visitor.*;

public interface CommandExecuter4Public extends Anything, Runnable, AbstractPersistentProxi {
    
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public Command commandGet() 
				throws PersistenceException;
    public void commandPut(final Command command) 
				throws PersistenceException;
    public void finishCommand(final CommitConnectionHandler handler, final long signal) 
				throws PersistenceException;
    public void handleFatalException(final Throwable t, final Command c) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void interrupt() 
				throws PersistenceException;
    public boolean isAlive() 
				throws PersistenceException;
    public void run() ;
    public void start() 
				throws PersistenceException;

}

