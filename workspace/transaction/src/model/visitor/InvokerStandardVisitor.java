
package model.visitor;

import persistence.*;

public abstract class InvokerStandardVisitor implements InvokerVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Invoker invoker) throws PersistenceException;
}
