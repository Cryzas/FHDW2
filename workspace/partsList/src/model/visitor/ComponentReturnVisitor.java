
package model.visitor;

import persistence.*;

public interface ComponentReturnVisitor<R> {
    
    public R handleMaterial(Material4Public material) throws PersistenceException;
    public R handleProduct(Product4Public product) throws PersistenceException;
    
}
