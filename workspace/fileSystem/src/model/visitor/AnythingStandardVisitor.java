
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException{
        this.standardHandling(addContaineeCommand);
    }
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException{
        this.standardHandling(deleteCommand);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException{
        this.standardHandling(filledCBState);
    }
    public void handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException{
        this.standardHandling(fileSystem);
    }
    public void handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException{
        this.standardHandling(emptyCBState);
    }
    public void handleFile(File4Public file) throws PersistenceException{
        this.standardHandling(file);
    }
    public void handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException{
        this.standardHandling(clipBoard);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleDirectory(Directory4Public directory) throws PersistenceException{
        this.standardHandling(directory);
    }
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException{
        this.standardHandling(changeContentsCommand);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
