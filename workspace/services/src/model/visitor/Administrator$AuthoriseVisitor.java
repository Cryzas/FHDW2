
package model.visitor;

import persistence.*;

public abstract class Administrator$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
