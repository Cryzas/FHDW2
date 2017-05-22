
package view.visitor;

import view.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdministrator(AdministratorView administrator) throws ModelException;
    public R handleCustomer(CustomerView customer) throws ModelException;
    public R handleRegister(RegisterView register) throws ModelException;
    public R handleUserManager(UserManagerView userManager) throws ModelException;
    
}
