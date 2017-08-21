
package view.visitor;
import view.*;

public interface ComponentExceptionVisitor<E extends view.UserException> {
    
    public void handleMaterial(MaterialView material) throws ModelException, E;
    public void handleProduct(ProductView product) throws ModelException, E;
    
}
