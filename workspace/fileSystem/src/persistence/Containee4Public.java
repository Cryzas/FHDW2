package persistence;


import model.visitor.*;

public interface Containee4Public extends Anything, FileTreeHIERARCHY, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    
    public void accept(ContaineeVisitor visitor) throws PersistenceException;
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void delete(final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void delete() 
				throws model.FileSystemException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

