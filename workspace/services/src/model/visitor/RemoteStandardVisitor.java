
package model.visitor;

import persistence.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleAdministrator(Administrator4Public administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleCustomer(Customer4Public customer) throws PersistenceException{
        this.standardHandling(customer);
    }
    public void handleRegister(Register4Public register) throws PersistenceException{
        this.standardHandling(register);
    }
    public void handleUserManager(UserManager4Public userManager) throws PersistenceException{
        this.standardHandling(userManager);
    }
    protected abstract void standardHandling(Remote remote) throws PersistenceException;
}
