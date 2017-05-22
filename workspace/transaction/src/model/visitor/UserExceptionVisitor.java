
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleAccountException(model.AccountException accountException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleNotPartException(model.NotPartException notPartException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
