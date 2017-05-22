
package model.visitor;

import persistence.*;

public abstract class Register$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleRegister(PersistentRegister register) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
