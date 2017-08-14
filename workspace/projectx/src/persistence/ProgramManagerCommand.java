package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ProgramManagerCommand extends  Command {
    
    

    public void accept(ProgramManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ProgramManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ProgramManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ProgramManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

