
package view.visitor;
import view.*;

public interface ComponentReturnVisitor<R> {
    
    public R handleMaterial(MaterialView material) throws ModelException;
    public R handleProduct(ProductView product) throws ModelException;
    
}
