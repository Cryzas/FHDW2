
package model.visitor;
import persistence.*;

public interface MyBooleanReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleBFalse(BFalse4Public bFalse) throws PersistenceException, E;
    public R handleBTrue(BTrue4Public bTrue) throws PersistenceException, E;
    
}
