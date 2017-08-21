
package model.visitor;
import persistence.*;

public interface ComponentReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleMaterial(Material4Public material) throws PersistenceException, E;
    public R handleProduct(Product4Public product) throws PersistenceException, E;
    
}
