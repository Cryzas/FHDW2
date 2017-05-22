
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleAdministrator(Administrator4Public administrator) throws PersistenceException{
        this.handleService(administrator);
    }
    public void handleCustomer(Customer4Public customer) throws PersistenceException{
        this.handleService(customer);
    }
    public void handleRegister(Register4Public register) throws PersistenceException{
        this.handleService(register);
    }
    public void handleUserManager(UserManager4Public userManager) throws PersistenceException{
        this.handleService(userManager);
    }
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    
}
