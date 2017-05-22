
package model.visitor;

import persistence.*;

public interface InvokerExceptionVisitor<E extends model.UserException> extends ServiceExceptionVisitor<E>{
    
    public void handleServer(Server4Public server) throws PersistenceException, E;
    
}
