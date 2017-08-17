
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleUnitSwapException(UnitSwapException unitSwapException) throws ModelException{
        this.standardHandling(unitSwapException);
    }
    public void handleinvalidGradeSysteException(invalidGradeSysteException invalidGradeSysteException) throws ModelException{
        this.standardHandling(invalidGradeSysteException);
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
