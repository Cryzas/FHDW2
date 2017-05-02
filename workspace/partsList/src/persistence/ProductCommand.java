package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ProductCommand extends  Command {
    
    

    public void accept(ProductCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ProductCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ProductCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ProductCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

