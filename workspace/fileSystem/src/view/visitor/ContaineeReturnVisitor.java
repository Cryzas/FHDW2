
package view.visitor;

import view.*;

public interface ContaineeReturnVisitor<R> {
    
    public R handleDirectory(DirectoryView directory) throws ModelException;
    public R handleFile(FileView file) throws ModelException;
    
}
