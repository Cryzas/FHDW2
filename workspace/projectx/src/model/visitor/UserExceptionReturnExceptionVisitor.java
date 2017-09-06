
package model.visitor;
import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException, E;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleInvalidGradeForSystemException(model.InvalidGradeForSystemException invalidGradeForSystemException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public R handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException, E;
    
}
