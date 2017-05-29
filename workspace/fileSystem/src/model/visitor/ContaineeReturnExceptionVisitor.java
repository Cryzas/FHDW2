
package model.visitor;

import persistence.*;

public interface ContaineeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleDirectory(Directory4Public directory) throws PersistenceException, E;
    public R handleFile(File4Public file) throws PersistenceException, E;
    
}
