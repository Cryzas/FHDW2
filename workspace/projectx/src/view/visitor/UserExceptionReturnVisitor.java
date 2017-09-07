
package view.visitor;
import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAlreadyExistsInParentException(AlreadyExistsInParentException alreadyExistsInParentException) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleInvalidGradeForSystemException(InvalidGradeForSystemException invalidGradeForSystemException) throws ModelException;
    public R handleNoFractionValueException(NoFractionValueException noFractionValueException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleUnitSwapException(UnitSwapException unitSwapException) throws ModelException;
    
}
