
package model.visitor;

import persistence.*;

public interface InvokerVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
