
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends ClipBoardStateExceptionVisitor<E>,ContaineeExceptionVisitor<E>{
    
    public void handleClipBoard(ClipBoardView clipBoard) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleFileSystem(FileSystemView fileSystem) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
