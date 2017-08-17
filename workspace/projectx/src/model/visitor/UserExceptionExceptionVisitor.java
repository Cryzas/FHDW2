
package model.visitor;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public void handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException, E;
    public void handleinvalidGradeSysteException(model.invalidGradeSysteException invalidGradeSysteException) throws PersistenceException, E;
    
}
