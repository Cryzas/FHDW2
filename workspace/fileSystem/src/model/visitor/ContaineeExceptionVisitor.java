
package model.visitor;

import persistence.*;

public interface ContaineeExceptionVisitor<E extends model.UserException> {
    
    public void handleDirectory(Directory4Public directory) throws PersistenceException, E;
    public void handleFile(File4Public file) throws PersistenceException, E;
    
}
