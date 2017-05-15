package persistence;


import model.visitor.*;

public interface Entry4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public Transfer4Public getTransfer() throws PersistenceException ;
    
    public void accept(EntryVisitor visitor) throws PersistenceException;
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

