
package model.visitor;

import persistence.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdministrator(Administrator4Public administrator) throws PersistenceException;
    public R handleCustomer(Customer4Public customer) throws PersistenceException;
    public R handleRegister(Register4Public register) throws PersistenceException;
    public R handleUserManager(UserManager4Public userManager) throws PersistenceException;
    
}
