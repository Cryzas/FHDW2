
package model.visitor;

import persistence.*;

public abstract class MyBooleanStandardVisitor implements MyBooleanVisitor {
    
    public void handleBFalse(BFalse4Public bFalse) throws PersistenceException{
        this.standardHandling(bFalse);
    }
    public void handleBTrue(BTrue4Public bTrue) throws PersistenceException{
        this.standardHandling(bTrue);
    }
    protected abstract void standardHandling(MyBoolean4Public myBoolean) throws PersistenceException;
}
