
package model.visitor;

import persistence.*;

public interface ComponentVisitor {
    
    public void handleMaterial(Material4Public material) throws PersistenceException;
    public void handleProduct(Product4Public product) throws PersistenceException;
    
}
