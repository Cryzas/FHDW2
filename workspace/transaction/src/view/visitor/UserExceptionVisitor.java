
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleAccountException(AccountException accountException) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleNotPartException(NotPartException notPartException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
