package persistence;

import model.visitor.*;

/* Additional import section end */

public interface TransferManagerCommand extends  Command {
    
    

    public void accept(TransferManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(TransferManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(TransferManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(TransferManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

