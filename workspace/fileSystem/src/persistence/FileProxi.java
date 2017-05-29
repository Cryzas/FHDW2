package persistence;



import model.visitor.*;

public class FileProxi extends ContaineeProxi implements PersistentFile{
    
    public FileProxi(long objectId) {
        super(objectId);
    }
    public FileProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 116;
    }
    
    public String getContents() throws PersistenceException {
        return ((PersistentFile)this.getTheObject()).getContents();
    }
    public void setContents(String newValue) throws PersistenceException {
        ((PersistentFile)this.getTheObject()).setContents(newValue);
    }
    public PersistentFile getThis() throws PersistenceException {
        return ((PersistentFile)this.getTheObject()).getThis();
    }
    
    public void accept(ContaineeVisitor visitor) throws PersistenceException {
        visitor.handleFile(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFile(this);
    }
    public <E extends model.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFile(this);
    }
    public <R, E extends model.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFile(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFile(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFile(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFile(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFile(this);
    }
    public void accept(FileTreeHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleFile(this);
    }
    public <R> R accept(FileTreeHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFile(this);
    }
    public <E extends model.UserException>  void accept(FileTreeHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFile(this);
    }
    public <R, E extends model.UserException> R accept(FileTreeHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFile(this);
    }
    
    
    public void changeContents(final String newContents, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).changeContents(newContents, invoker);
    }
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentFile)this.getTheObject()).containsFileTree(part);
    }
    public void delete(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).delete(invoker);
    }
    public DirectorySearchList getParent() 
				throws PersistenceException{
        return ((PersistentFile)this.getTheObject()).getParent();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentFile)this.getTheObject()).strategyFileTree(strategy);
    }
    public void changeContents(final String newContents) 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).changeContents(newContents);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void delete() 
				throws model.FileSystemException, PersistenceException{
        ((PersistentFile)this.getTheObject()).delete();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFile)this.getTheObject()).initializeOnInstantiation();
    }

    
}
