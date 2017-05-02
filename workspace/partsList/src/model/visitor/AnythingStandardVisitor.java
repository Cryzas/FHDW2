
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleProduct(Product4Public product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleMaterial(Material4Public material) throws PersistenceException{
        this.standardHandling(material);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException{
        this.standardHandling(quantifiedComponent);
    }
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException{
        this.standardHandling(createMaterialCommand);
    }
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException{
        this.standardHandling(addPartCommand);
    }
    public void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException{
        this.standardHandling(componentLst);
    }
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException{
        this.standardHandling(createProductCommand);
    }
    public void handlePartsListManager(PartsListManager4Public partsListManager) throws PersistenceException{
        this.standardHandling(partsListManager);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
