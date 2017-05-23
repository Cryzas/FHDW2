package persistence;


import model.visitor.*;

public interface Account4Public extends abstractAcc4Public {
    
    public Folder4Public getInBox() throws PersistenceException ;
    public Folder4Public getOutBox() throws PersistenceException ;
    public Folder4Public getDrafts() throws PersistenceException ;
    public Account_FoldersProxi getFolders() throws PersistenceException ;
    
    public void accept(abstractAccVisitor visitor) throws PersistenceException;
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public AccountWrapper4Public wrap() 
				throws PersistenceException;

}

