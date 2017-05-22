
package model.visitor;

import persistence.*;

public interface ServiceVisitor {
    
    public void handleAdministrator(Administrator4Public administrator) throws PersistenceException;
    public void handleCustomer(Customer4Public customer) throws PersistenceException;
    public void handleRegister(Register4Public register) throws PersistenceException;
    public void handleUserManager(UserManager4Public userManager) throws PersistenceException;
    
}
