package persistence;



import model.visitor.*;

public class FileSystemICProxi extends PersistentInCacheProxiOptimistic implements PersistentFileSystem{
    
    public FileSystemICProxi(long objectId) {
        super(objectId);
    }
    public FileSystemICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFileSystemFacade
            .getFileSystem(this.getId());
    }
    
    public long getClassId() {
        return 114;
    }
    
    public Directory4Public getSystemRoot() throws PersistenceException {
        return ((PersistentFileSystem)this.getTheObject()).getSystemRoot();
    }
    public void setSystemRoot(Directory4Public newValue) throws PersistenceException {
        ((PersistentFileSystem)this.getTheObject()).setSystemRoot(newValue);
    }
    public ClipBoard4Public getClipBoard() throws PersistenceException {
        return ((PersistentFileSystem)this.getTheObject()).getClipBoard();
    }
    public void setClipBoard(ClipBoard4Public newValue) throws PersistenceException {
        ((PersistentFileSystem)this.getTheObject()).setClipBoard(newValue);
    }
    public PersistentFileSystem getThis() throws PersistenceException {
        return ((PersistentFileSystem)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFileSystem(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFileSystem(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFileSystem(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFileSystem(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFileSystem)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFileSystem)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFileSystem)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFileSystem)this.getTheObject()).initializeOnInstantiation();
    }

    
}
