
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends ClipBoardStateReturnExceptionVisitor<R, E> ,ContaineeReturnExceptionVisitor<R, E> {
    
    public R handleClipBoard(ClipBoardView clipBoard) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleFileSystem(FileSystemView fileSystem) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
