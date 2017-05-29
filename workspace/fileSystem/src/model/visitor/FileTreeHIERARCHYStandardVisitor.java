
package model.visitor;

import persistence.*;

public abstract class FileTreeHIERARCHYStandardVisitor implements FileTreeHIERARCHYVisitor {
    
    public void handleFile(File4Public file) throws PersistenceException{
        this.standardHandling(file);
    }
    public void handleDirectory(Directory4Public directory) throws PersistenceException{
        this.standardHandling(directory);
    }
    protected abstract void standardHandling(FileTreeHIERARCHY fileTreeHIERARCHY) throws PersistenceException;
}
