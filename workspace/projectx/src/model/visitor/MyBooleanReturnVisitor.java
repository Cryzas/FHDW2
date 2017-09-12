
package model.visitor;
import persistence.*;

public interface MyBooleanReturnVisitor<R> {
    
    public R handleBFalse(BFalse4Public bFalse) throws PersistenceException;
    public R handleBTrue(BTrue4Public bTrue) throws PersistenceException;
    
}
