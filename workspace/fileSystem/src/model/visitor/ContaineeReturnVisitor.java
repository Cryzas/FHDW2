
package model.visitor;

import persistence.*;

public interface ContaineeReturnVisitor<R> {
    
    public R handleDirectory(Directory4Public directory) throws PersistenceException;
    public R handleFile(File4Public file) throws PersistenceException;
    
}
