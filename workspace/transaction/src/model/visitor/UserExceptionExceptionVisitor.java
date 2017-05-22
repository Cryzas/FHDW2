
package model.visitor;

import persistence.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleAccountException(model.AccountException accountException) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleNotPartException(model.NotPartException notPartException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
