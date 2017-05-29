package persistence;

import model.visitor.*;

/* Additional import section end */

public interface DirectoryCommand extends  Command {
    
    

    public void accept(DirectoryCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(DirectoryCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(DirectoryCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(DirectoryCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

