
package model.visitor;
import persistence.*;

public interface AccountExceptionVisitor<E extends model.UserException> {
    
    public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException, E;
    public void handleAccount(Account4Public account) throws PersistenceException, E;
    
}
