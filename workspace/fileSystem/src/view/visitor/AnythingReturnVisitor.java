
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ClipBoardStateReturnVisitor<R> ,ContaineeReturnVisitor<R> {
    
    public R handleClipBoard(ClipBoardView clipBoard) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleFileSystem(FileSystemView fileSystem) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
