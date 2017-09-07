
package model.visitor;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleInvalidGradeForSystemException(model.InvalidGradeForSystemException invalidGradeForSystemException) throws PersistenceException, E;
    public void handleNoFractionValueException(model.NoFractionValueException noFractionValueException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public void handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException, E;
    
}
