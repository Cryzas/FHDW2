package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ManagerCommand extends  Command {
    
    

    public void accept(ManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

