
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleAccountException(AccountException accountException) throws ModelException{
        this.standardHandling(accountException);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    public void handleNotPartException(NotPartException notPartException) throws ModelException{
        this.standardHandling(notPartException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
