
package model.visitor;
import persistence.*;

public interface MyBooleanExceptionVisitor<E extends model.UserException> {
    
    public void handleBFalse(BFalse4Public bFalse) throws PersistenceException, E;
    public void handleBTrue(BTrue4Public bTrue) throws PersistenceException, E;
    
}
