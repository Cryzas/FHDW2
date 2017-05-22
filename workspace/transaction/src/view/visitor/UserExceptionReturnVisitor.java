
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAccountException(AccountException accountException) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleNotPartException(NotPartException notPartException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
