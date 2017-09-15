package persistence;

import model.visitor.*;

/* Additional import section end */

public interface StudentManagerCommand extends  Command {
    
    

    public void accept(StudentManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(StudentManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(StudentManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(StudentManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

