
package model.visitor;

import persistence.*;

public abstract class Customer$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleCustomer(PersistentCustomer customer) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
