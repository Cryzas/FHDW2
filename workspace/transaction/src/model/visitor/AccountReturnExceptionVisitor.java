
package model.visitor;
import persistence.*;

public interface AccountReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleNoAccount(NoAccount4Public noAccount) throws PersistenceException, E;
    public R handleAccount(Account4Public account) throws PersistenceException, E;
    
}
