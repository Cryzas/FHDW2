
package model.visitor;

import persistence.*;

public abstract class ContaineeStandardVisitor implements ContaineeVisitor {
    
    public void handleFile(File4Public file) throws PersistenceException{
        this.standardHandling(file);
    }
    public void handleDirectory(Directory4Public directory) throws PersistenceException{
        this.standardHandling(directory);
    }
    protected abstract void standardHandling(Containee4Public containee) throws PersistenceException;
}
