
package model.visitor;

import persistence.*;

public interface FileCommandVisitor {
    
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException;
    
}
