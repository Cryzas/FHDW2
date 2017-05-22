
package view.visitor;

import view.*;

public interface ServiceExceptionVisitor<E extends view.UserException> {
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException, E;
    public void handleCustomer(CustomerView customer) throws ModelException, E;
    public void handleRegister(RegisterView register) throws ModelException, E;
    public void handleUserManager(UserManagerView userManager) throws ModelException, E;
    
}
