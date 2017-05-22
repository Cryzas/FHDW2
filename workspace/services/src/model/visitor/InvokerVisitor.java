
package model.visitor;

import persistence.*;

public interface InvokerVisitor extends ServiceVisitor{
    
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
