
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleCustomer(PersistentCustomer customer) throws PersistenceException;
    public abstract void handleRegister(PersistentRegister register) throws PersistenceException;
    public abstract void handleUserManager(PersistentUserManager userManager) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
