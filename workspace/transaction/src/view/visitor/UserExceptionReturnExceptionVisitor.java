
package view.visitor;

import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAccountException(AccountException accountException) throws ModelException, E;
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
