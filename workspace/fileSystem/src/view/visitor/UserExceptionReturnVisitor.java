
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleFileSystemException(FileSystemException fileSystemException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
