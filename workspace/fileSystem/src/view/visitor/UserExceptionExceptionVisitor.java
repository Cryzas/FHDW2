
package view.visitor;

import view.*;

public interface UserExceptionExceptionVisitor<E extends view.UserException> {
    
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleFileSystemException(FileSystemException fileSystemException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
