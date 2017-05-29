
package model.visitor;

import persistence.*;

public interface FileCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException, E;
    
}
