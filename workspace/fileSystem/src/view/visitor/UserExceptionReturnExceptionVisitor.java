
package view.visitor;

import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleFileSystemException(FileSystemException fileSystemException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
