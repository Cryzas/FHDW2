
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException{
        this.standardHandling(deleteCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException{
        this.standardHandling(addContaineeCommand);
    }
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException{
        this.standardHandling(changeContentsCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
