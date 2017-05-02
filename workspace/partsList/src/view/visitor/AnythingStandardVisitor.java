
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleProduct(ProductView product) throws ModelException{
        this.standardHandling(product);
    }
    public void handleMaterial(MaterialView material) throws ModelException{
        this.standardHandling(material);
    }
    public void handleQuantifiedComponent(QuantifiedComponentView quantifiedComponent) throws ModelException{
        this.standardHandling(quantifiedComponent);
    }
    public void handleComponentLst(ComponentLstView componentLst) throws ModelException{
        this.standardHandling(componentLst);
    }
    public void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException{
        this.standardHandling(partsListManager);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
