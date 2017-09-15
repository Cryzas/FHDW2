
package model.visitor;
import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException;
    public void handleAlreadyFinishedException(model.AlreadyFinishedException alreadyFinishedException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleInvalidGradeForSystemException(model.InvalidGradeForSystemException invalidGradeForSystemException) throws PersistenceException;
    public void handleNoFractionValueException(model.NoFractionValueException noFractionValueException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public void handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException;
    
}
