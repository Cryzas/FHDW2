
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends ClipBoardStateReturnVisitor<R> ,CommonDateReturnVisitor<R> ,ContaineeReturnVisitor<R> {
    
    public R handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException;
    public R handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException;
    public R handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    
}
