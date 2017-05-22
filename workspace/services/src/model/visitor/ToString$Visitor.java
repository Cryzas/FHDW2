
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleAdministrator(Administrator4Public administrator) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleCustomer(Customer4Public customer) throws PersistenceException;
    public abstract void handleRegister(Register4Public register) throws PersistenceException;
    public abstract void handleUserManager(UserManager4Public userManager) throws PersistenceException;
    
}
