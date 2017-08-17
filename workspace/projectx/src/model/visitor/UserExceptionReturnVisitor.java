
package model.visitor;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException;
    public R handleinvalidGradeSysteException(model.invalidGradeSysteException invalidGradeSysteException) throws PersistenceException;
    
}
