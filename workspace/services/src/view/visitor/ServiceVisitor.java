
package view.visitor;

import view.*;

public interface ServiceVisitor {
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException;
    public void handleCustomer(CustomerView customer) throws ModelException;
    public void handleRegister(RegisterView register) throws ModelException;
    public void handleUserManager(UserManagerView userManager) throws ModelException;
    
}
