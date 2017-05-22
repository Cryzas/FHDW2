
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
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
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
