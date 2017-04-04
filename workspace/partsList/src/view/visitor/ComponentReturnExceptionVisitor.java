
package view.visitor;

import view.*;

public interface ComponentReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleMaterial(MaterialView material) throws ModelException, E;
    public R handleProduct(ProductView product) throws ModelException, E;
    
}
