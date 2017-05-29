
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleFileSystem(PersistentFileSystem fileSystem) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleFile(PersistentFile file) throws PersistenceException;
    public abstract void handleClipBoard(PersistentClipBoard clipBoard) throws PersistenceException;
    public abstract void handleDirectory(PersistentDirectory directory) throws PersistenceException;
    
}
