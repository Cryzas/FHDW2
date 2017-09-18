
package model.visitor;
import persistence.*;

public interface AccountReturnVisitor<R> {
    
    public R handleNoAccount(NoAccount4Public noAccount) throws PersistenceException;
    public R handleAccount(Account4Public account) throws PersistenceException;
    
}
