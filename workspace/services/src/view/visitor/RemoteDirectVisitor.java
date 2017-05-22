
package view.visitor;

import view.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.handleService(administrator);
    }
    public void handleCustomer(CustomerView customer) throws ModelException{
        this.handleService(customer);
    }
    public void handleRegister(RegisterView register) throws ModelException{
        this.handleService(register);
    }
    public void handleUserManager(UserManagerView userManager) throws ModelException{
        this.handleService(userManager);
    }
    
}
