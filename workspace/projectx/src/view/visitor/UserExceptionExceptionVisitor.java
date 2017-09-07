
package view.visitor;
import view.*;

public interface UserExceptionExceptionVisitor<E extends view.UserException> {
    
    public void handleAlreadyExistsInParentException(AlreadyExistsInParentException alreadyExistsInParentException) throws ModelException, E;
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleInvalidGradeForSystemException(InvalidGradeForSystemException invalidGradeForSystemException) throws ModelException, E;
    public void handleNoFractionValueException(NoFractionValueException noFractionValueException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public void handleUnitSwapException(UnitSwapException unitSwapException) throws ModelException, E;
    
}
