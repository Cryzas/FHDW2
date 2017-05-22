
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleAdministrator(Administrator4Public administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleCustomer(Customer4Public customer) throws PersistenceException{
        this.standardHandling(customer);
    }
    public void handleRegister(Register4Public register) throws PersistenceException{
        this.standardHandling(register);
    }
    public void handleUserManager(UserManager4Public userManager) throws PersistenceException{
        this.standardHandling(userManager);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
