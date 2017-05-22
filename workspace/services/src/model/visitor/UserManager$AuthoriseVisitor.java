
package model.visitor;

import persistence.*;

public abstract class UserManager$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleUserManager(PersistentUserManager userManager) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
