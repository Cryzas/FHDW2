package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ModuleManagerCommand extends  Command {
    
    

    public void accept(ModuleManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

