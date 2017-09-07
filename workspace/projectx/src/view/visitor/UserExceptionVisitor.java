
package view.visitor;
import view.*;

public interface UserExceptionVisitor {
    
    public void handleAlreadyExistsInParentException(AlreadyExistsInParentException alreadyExistsInParentException) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleInvalidGradeForSystemException(InvalidGradeForSystemException invalidGradeForSystemException) throws ModelException;
    public void handleNoFractionValueException(NoFractionValueException noFractionValueException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleUnitSwapException(UnitSwapException unitSwapException) throws ModelException;
    
}
