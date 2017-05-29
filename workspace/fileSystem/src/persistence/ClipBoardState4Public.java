package persistence;


import model.visitor.*;

public interface ClipBoardState4Public extends Anything, AbstractPersistentProxi {
    
    
    public void accept(ClipBoardStateVisitor visitor) throws PersistenceException;
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

