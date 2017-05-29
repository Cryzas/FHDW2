
package view.visitor;

import view.*;

public interface ContaineeReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleDirectory(DirectoryView directory) throws ModelException, E;
    public R handleFile(FileView file) throws ModelException, E;
    
}
