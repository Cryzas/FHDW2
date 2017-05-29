
package model.visitor;

import persistence.*;

public abstract class FileCommandStandardVisitor implements FileCommandVisitor {
    
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException{
        this.standardHandling(changeContentsCommand);
    }
    protected abstract void standardHandling(FileCommand fileCommand) throws PersistenceException;
}
