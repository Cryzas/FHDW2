
package model.visitor;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAccountException(model.AccountException accountException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleTransferException(model.TransferException transferException) throws PersistenceException;
    
}
