
package model.visitor;

import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handlePartsListException(model.PartsListException partsListException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
