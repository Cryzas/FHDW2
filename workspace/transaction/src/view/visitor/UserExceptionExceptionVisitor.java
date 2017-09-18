
package view.visitor;
import view.*;

public interface UserExceptionExceptionVisitor<E extends view.UserException> {
    
    public void handleAccountException(AccountException accountException) throws ModelException, E;
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public void handleTransferException(TransferException transferException) throws ModelException, E;
    
}
