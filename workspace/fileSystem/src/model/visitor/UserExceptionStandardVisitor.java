
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleFileSystemException(model.FileSystemException fileSystemException) throws PersistenceException{
        this.standardHandling(fileSystemException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
