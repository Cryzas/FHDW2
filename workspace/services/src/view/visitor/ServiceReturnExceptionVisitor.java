
package view.visitor;

import view.*;

public interface ServiceReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAdministrator(AdministratorView administrator) throws ModelException, E;
    public R handleCustomer(CustomerView customer) throws ModelException, E;
    public R handleRegister(RegisterView register) throws ModelException, E;
    public R handleUserManager(UserManagerView userManager) throws ModelException, E;
    
}
