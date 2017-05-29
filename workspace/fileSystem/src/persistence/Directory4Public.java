package persistence;


import model.visitor.*;

public interface Directory4Public extends Containee4Public {
    
    public Directory_ContentsProxi getContents() throws PersistenceException ;
    
    public void accept(ContaineeVisitor visitor) throws PersistenceException;
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(FileTreeHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(FileTreeHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(FileTreeHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(FileTreeHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addContainee(final Containee4Public containee, final Invoker invoker) 
				throws PersistenceException;
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void addContainee(final Containee4Public containee) 
				throws model.FileSystemException, model.CycleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

