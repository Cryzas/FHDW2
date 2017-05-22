
package view.visitor;

import view.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.standardHandling(administrator);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleCustomer(CustomerView customer) throws ModelException{
        this.standardHandling(customer);
    }
    public void handleRegister(RegisterView register) throws ModelException{
        this.standardHandling(register);
    }
    public void handleUserManager(UserManagerView userManager) throws ModelException{
        this.standardHandling(userManager);
    }
    protected abstract void standardHandling(Remote remote) throws ModelException;
}
