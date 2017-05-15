package persistence;


import model.visitor.*;

public interface AccountHandle4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public Account4Public fetchAccount() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

