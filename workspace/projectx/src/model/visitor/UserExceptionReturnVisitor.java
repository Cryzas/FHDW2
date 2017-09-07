
package model.visitor;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleInvalidGradeForSystemException(model.InvalidGradeForSystemException invalidGradeForSystemException) throws PersistenceException;
    public R handleNoFractionValueException(model.NoFractionValueException noFractionValueException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException;
    
}
