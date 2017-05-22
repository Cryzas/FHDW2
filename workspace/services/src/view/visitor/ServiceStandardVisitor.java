
package view.visitor;

import view.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.standardHandling(administrator);
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
    protected abstract void standardHandling(ServiceView service) throws ModelException;
}
