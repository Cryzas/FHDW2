
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException;
    public abstract void handleProduct(Product4Public product) throws PersistenceException;
    public abstract void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException;
    public abstract void handleMaterial(Material4Public material) throws PersistenceException;
    
}
