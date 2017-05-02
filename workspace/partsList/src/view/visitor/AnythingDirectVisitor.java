
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleQuantifiedComponent(QuantifiedComponentView quantifiedComponent) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleComponentLst(ComponentLstView componentLst) throws ModelException;
    
    public abstract void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException;
    
    public abstract void handleComponent(ComponentView component) throws ModelException;
    
    public void handleProduct(ProductView product) throws ModelException{
        this.handleComponent(product);
    }
    public void handleMaterial(MaterialView material) throws ModelException{
        this.handleComponent(material);
    }
    
}
