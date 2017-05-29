
package view.visitor;

import view.*;

public interface ContaineeExceptionVisitor<E extends view.UserException> {
    
    public void handleDirectory(DirectoryView directory) throws ModelException, E;
    public void handleFile(FileView file) throws ModelException, E;
    
}
