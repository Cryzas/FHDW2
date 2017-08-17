
package model.visitor;
import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleAlreadyExistsInParentException(model.AlreadyExistsInParentException alreadyExistsInParentException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public void handleUnitSwapException(model.UnitSwapException unitSwapException) throws PersistenceException;
    public void handleinvalidGradeSysteException(model.invalidGradeSysteException invalidGradeSysteException) throws PersistenceException;
    
}
