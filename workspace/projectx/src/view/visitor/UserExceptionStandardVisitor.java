
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleAlreadyFinishedException(AlreadyFinishedException alreadyFinishedException) throws ModelException{
        this.standardHandling(alreadyFinishedException);
    }
    public void handleInvalidGradeForSystemException(InvalidGradeForSystemException invalidGradeForSystemException) throws ModelException{
        this.standardHandling(invalidGradeForSystemException);
    }
    public void handleUnitSwapException(UnitSwapException unitSwapException) throws ModelException{
        this.standardHandling(unitSwapException);
    }
    public void handleNoFractionValueException(NoFractionValueException noFractionValueException) throws ModelException{
        this.standardHandling(noFractionValueException);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleAlreadyExistsInParentException(AlreadyExistsInParentException alreadyExistsInParentException) throws ModelException{
        this.standardHandling(alreadyExistsInParentException);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
