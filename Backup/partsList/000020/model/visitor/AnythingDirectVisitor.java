
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException;
    
    public abstract void handleComponent(Component4Public component) throws PersistenceException;
    
    public void handleProduct(Product4Public product) throws PersistenceException{
        this.handleComponent(product);
    }
    public void handleMaterial(Material4Public material) throws PersistenceException{
        this.handleComponent(material);
    }
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    
}
