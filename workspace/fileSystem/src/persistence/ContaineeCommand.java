package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ContaineeCommand extends  Command {
    
    

    public void accept(ContaineeCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ContaineeCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ContaineeCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ContaineeCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

