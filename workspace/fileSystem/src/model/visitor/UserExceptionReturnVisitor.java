
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleFileSystemException(model.FileSystemException fileSystemException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
