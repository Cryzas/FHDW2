
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleQuantifiedComponent(PersistentQuantifiedComponent quantifiedComponent) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleProduct(PersistentProduct product) throws PersistenceException;
    public abstract void handleComponentLst(PersistentComponentLst componentLst) throws PersistenceException;
    public abstract void handleMaterial(PersistentMaterial material) throws PersistenceException;
    
}
