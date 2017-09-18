
package model.visitor;
import persistence.*;

public interface AccountVisitor {
    
    public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException;
    public void handleAccount(Account4Public account) throws PersistenceException;
    
}
