
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleFilledCBState(FilledCBStateView filledCBState) throws ModelException{
        this.standardHandling(filledCBState);
    }
    public void handleFileSystem(FileSystemView fileSystem) throws ModelException{
        this.standardHandling(fileSystem);
    }
    public void handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException{
        this.standardHandling(emptyCBState);
    }
    public void handleFile(FileView file) throws ModelException{
        this.standardHandling(file);
    }
    public void handleClipBoard(ClipBoardView clipBoard) throws ModelException{
        this.standardHandling(clipBoard);
    }
    public void handleDirectory(DirectoryView directory) throws ModelException{
        this.standardHandling(directory);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
