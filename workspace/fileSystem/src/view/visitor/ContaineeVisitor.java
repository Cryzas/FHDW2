
package view.visitor;

import view.*;

public interface ContaineeVisitor {
    
    public void handleDirectory(DirectoryView directory) throws ModelException;
    public void handleFile(FileView file) throws ModelException;
    
}
