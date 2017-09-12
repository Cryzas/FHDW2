
package view.visitor;
import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAlreadyExistsInParentException(AlreadyExistsInParentException alreadyExistsInParentException) throws ModelException, E;
    public R handleAlreadyFinishedException(AlreadyFinishedException alreadyFinishedException) throws ModelException, E;
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleInvalidGradeForSystemException(InvalidGradeForSystemException invalidGradeForSystemException) throws ModelException, E;
    public R handleNoFractionValueException(NoFractionValueException noFractionValueException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public R handleUnitSwapException(UnitSwapException unitSwapException) throws ModelException, E;
    
}
