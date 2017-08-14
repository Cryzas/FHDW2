
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException{
        this.standardHandling(answerCommand);
    }
    public void handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException{
        this.standardHandling(answerAllCommand);
    }
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException{
        this.standardHandling(sendCommand);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException{
        this.standardHandling(createDraftCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException{
        this.standardHandling(addReceiverCommand);
    }
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException{
        this.standardHandling(createFolderCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
