
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends ClipBoardStateReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,ContaineeReturnExceptionVisitor<R, E> {
    
    public R handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException, E;
    public R handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException, E;
    public R handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    
}
