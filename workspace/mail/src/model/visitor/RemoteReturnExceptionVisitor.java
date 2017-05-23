
package model.visitor;

import persistence.*;

public interface RemoteReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleServer(Server4Public server) throws PersistenceException, E;
    
}
