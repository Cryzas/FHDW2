
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleUserHasRightException(UserHasRightException userHasRightException) throws ModelException;
    
}
