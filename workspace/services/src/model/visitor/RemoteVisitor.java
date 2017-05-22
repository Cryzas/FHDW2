
package model.visitor;

import persistence.*;

public interface RemoteVisitor extends ServiceVisitor{
    
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
