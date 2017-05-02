package persistence;

import model.visitor.*;

/* Additional import section end */

public interface PartsListManagerCommand extends  Command {
    
    

    public void accept(PartsListManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(PartsListManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(PartsListManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(PartsListManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

