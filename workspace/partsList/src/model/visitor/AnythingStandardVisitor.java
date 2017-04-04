
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException{
        this.standardHandling(quantifiedComponent);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleProduct(Product4Public product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException{
        this.standardHandling(componentLst);
    }
    public void handleMaterial(Material4Public material) throws PersistenceException{
        this.standardHandling(material);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
