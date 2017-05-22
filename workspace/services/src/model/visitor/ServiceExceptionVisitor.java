
package model.visitor;

import persistence.*;

public interface ServiceExceptionVisitor<E extends model.UserException> {
    
    public void handleAdministrator(Administrator4Public administrator) throws PersistenceException, E;
    public void handleCustomer(Customer4Public customer) throws PersistenceException, E;
    public void handleRegister(Register4Public register) throws PersistenceException, E;
    public void handleUserManager(UserManager4Public userManager) throws PersistenceException, E;
    
}
