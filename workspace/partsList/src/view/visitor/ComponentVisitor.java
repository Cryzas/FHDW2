
package view.visitor;

import view.*;

public interface ComponentVisitor {
    
    public void handleMaterial(MaterialView material) throws ModelException;
    public void handleProduct(ProductView product) throws ModelException;
    
}
