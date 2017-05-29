
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException;
    public abstract void handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException;
    public abstract void handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException;
    public abstract void handleFile(File4Public file) throws PersistenceException;
    public abstract void handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException;
    public abstract void handleDirectory(Directory4Public directory) throws PersistenceException;
    
}
