
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleAccountException(model.AccountException accountException) throws PersistenceException{
        this.standardHandling(accountException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleNotPartException(model.NotPartException notPartException) throws PersistenceException{
        this.standardHandling(notPartException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
