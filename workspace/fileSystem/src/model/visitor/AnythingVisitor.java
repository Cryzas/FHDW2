
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends ClipBoardStateVisitor,CommonDateVisitor,ContaineeVisitor{
    
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException;
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException;
    public void handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
