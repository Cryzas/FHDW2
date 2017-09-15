
package model.visitor;
import persistence.*;

public interface MyBooleanVisitor {
    
    public void handleBFalse(BFalse4Public bFalse) throws PersistenceException;
    public void handleBTrue(BTrue4Public bTrue) throws PersistenceException;
    
}
