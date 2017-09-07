
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleInvalidGradeForSystemException(model.InvalidGradeForSystemException invalidGradeForSystemException) throws PersistenceException{
        this.standardHandling(invalidGradeForSystemException);
    }
    public void handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException{
        this.standardHandling(unitSwapException);
    }
    public void handleNoFractionValueException(model.NoFractionValueException noFractionValueException) throws PersistenceException{
        this.standardHandling(noFractionValueException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException{
        this.standardHandling(alreadyExistsInParentException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
