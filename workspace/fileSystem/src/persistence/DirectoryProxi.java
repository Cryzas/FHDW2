package persistence;



import model.visitor.*;

public class DirectoryProxi extends ContaineeProxi implements PersistentDirectory{
    
    public DirectoryProxi(long objectId) {
        super(objectId);
    }
    public DirectoryProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 117;
    }
    
    public Directory_ContentsProxi getContents() throws PersistenceException {
        return ((PersistentDirectory)this.getTheObject()).getContents();
    }
    public PersistentDirectory getThis() throws PersistenceException {
        return ((PersistentDirectory)this.getTheObject()).getThis();
    }
    
    public void accept(ContaineeVisitor visitor) throws PersistenceException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDirectory(this);
    }
    public <E extends model.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends model.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDirectory(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDirectory(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDirectory(this);
    }
    public void accept(FileTreeHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(FileTreeHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDirectory(this);
    }
    public <E extends model.UserException>  void accept(FileTreeHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends model.UserException> R accept(FileTreeHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDirectory(this);
    }
    
    
    public void addContainee(final Containee4Public containee, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentDirectory)this.getTheObject()).addContainee(containee, invoker);
    }
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentDirectory)this.getTheObject()).containsFileTree(part);
    }
    public void delete(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentDirectory)this.getTheObject()).delete(invoker);
    }
    public DirectorySearchList getParent() 
				throws PersistenceException{
        return ((PersistentDirectory)this.getTheObject()).getParent();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDirectory)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentDirectory)this.getTheObject()).strategyFileTree(strategy);
    }
    public void addContainee(final Containee4Public containee) 
				throws model.FileSystemException, model.CycleException, PersistenceException{
        ((PersistentDirectory)this.getTheObject()).addContainee(containee);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDirectory)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void delete() 
				throws model.FileSystemException, PersistenceException{
        ((PersistentDirectory)this.getTheObject()).delete();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDirectory)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDirectory)this.getTheObject()).initializeOnInstantiation();
    }

    
}
