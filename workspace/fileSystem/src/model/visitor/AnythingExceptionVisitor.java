
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends ClipBoardStateExceptionVisitor<E>,CommonDateExceptionVisitor<E>,ContaineeExceptionVisitor<E>{
    
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException, E;
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException, E;
    public void handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    
}
