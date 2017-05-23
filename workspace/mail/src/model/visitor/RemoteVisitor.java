
package model.visitor;

import persistence.*;

public interface RemoteVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
