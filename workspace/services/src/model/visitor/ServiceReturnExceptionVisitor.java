
package model.visitor;

import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAdministrator(Administrator4Public administrator) throws PersistenceException, E;
    public R handleCustomer(Customer4Public customer) throws PersistenceException, E;
    public R handleRegister(Register4Public register) throws PersistenceException, E;
    public R handleUserManager(UserManager4Public userManager) throws PersistenceException, E;
    
}
