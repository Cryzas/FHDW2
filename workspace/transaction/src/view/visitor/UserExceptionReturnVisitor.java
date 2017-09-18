
package view.visitor;
import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAccountException(AccountException accountException) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleTransferException(TransferException transferException) throws ModelException;
    
}
