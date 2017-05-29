
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleClipBoardState(ClipBoardStateView clipBoardState) throws ModelException;
    
    public void handleFilledCBState(FilledCBStateView filledCBState) throws ModelException{
        this.handleClipBoardState(filledCBState);
    }
    public void handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException{
        this.handleClipBoardState(emptyCBState);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleContainee(ContaineeView containee) throws ModelException;
    
    public void handleFile(FileView file) throws ModelException{
        this.handleContainee(file);
    }
    public void handleDirectory(DirectoryView directory) throws ModelException{
        this.handleContainee(directory);
    }
    public abstract void handleFileSystem(FileSystemView fileSystem) throws ModelException;
    
    public abstract void handleClipBoard(ClipBoardView clipBoard) throws ModelException;
    
    
}
