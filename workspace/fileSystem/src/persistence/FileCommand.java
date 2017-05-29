package persistence;

import model.visitor.*;

/* Additional import section end */

public interface FileCommand extends  Command {
    
    

    public void accept(FileCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(FileCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(FileCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(FileCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

