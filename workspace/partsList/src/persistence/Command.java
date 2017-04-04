package persistence;


/* Additional import section end */

public interface Command extends AbstractPersistentProxi {
    
    
    public void checkException() 
				throws model.UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public Invoker fetchInvoker() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

    
}

