
package view.visitor;

import view.*;

public abstract class ContaineeStandardVisitor implements ContaineeVisitor {
    
    public void handleFile(FileView file) throws ModelException{
        this.standardHandling(file);
    }
    public void handleDirectory(DirectoryView directory) throws ModelException{
        this.standardHandling(directory);
    }
    protected abstract void standardHandling(ContaineeView containee) throws ModelException;
}
