package persistence;

import model.visitor.*;

/* Additional import section end */

public interface Remote extends AbstractPersistentProxi {
    
    
    public void connected(final String user) 
				throws PersistenceException;
    public void disconnected() 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;

    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

