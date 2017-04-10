
package model.visitor;

import persistence.*;

public abstract class ComponentStandardVisitor implements ComponentVisitor {
    
    public void handleProduct(Product4Public product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleMaterial(Material4Public material) throws PersistenceException{
        this.standardHandling(material);
    }
    protected abstract void standardHandling(Component4Public component) throws PersistenceException;
}
