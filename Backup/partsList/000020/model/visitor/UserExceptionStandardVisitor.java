
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handlePartsListException(model.PartsListException partsListException) throws PersistenceException{
        this.standardHandling(partsListException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
