
package model.visitor;

import persistence.*;

public interface ContaineeVisitor {
    
    public void handleDirectory(Directory4Public directory) throws PersistenceException;
    public void handleFile(File4Public file) throws PersistenceException;
    
}
