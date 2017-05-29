
package view.visitor;

import view.*;

public interface AnythingVisitor extends ClipBoardStateVisitor,ContaineeVisitor{
    
    public void handleClipBoard(ClipBoardView clipBoard) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleFileSystem(FileSystemView fileSystem) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
