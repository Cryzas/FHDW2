
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleClipBoardState(ClipBoardState4Public clipBoardState) throws PersistenceException;
    
    public void handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException{
        this.handleClipBoardState(filledCBState);
    }
    public void handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException{
        this.handleClipBoardState(emptyCBState);
    }
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleContainee(Containee4Public containee) throws PersistenceException;
    
    public void handleFile(File4Public file) throws PersistenceException{
        this.handleContainee(file);
    }
    public void handleDirectory(Directory4Public directory) throws PersistenceException{
        this.handleContainee(directory);
    }
    public abstract void handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException;
    
    public abstract void handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException{
        this.handleCommonDate(deleteCommand);
    }
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException{
        this.handleCommonDate(addContaineeCommand);
    }
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException{
        this.handleCommonDate(changeContentsCommand);
    }
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    
}
