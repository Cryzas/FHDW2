
package model.visitor;
import persistence.*;

public interface ComponentExceptionVisitor<E extends model.UserException> {
    
    public void handleMaterial(Material4Public material) throws PersistenceException, E;
    public void handleProduct(Product4Public product) throws PersistenceException, E;
    
}
