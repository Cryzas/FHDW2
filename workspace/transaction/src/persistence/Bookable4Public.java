package persistence;


import model.visitor.*;

public interface Bookable4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public String getSubject() throws PersistenceException ;
    
    public void accept(BookableVisitor visitor) throws PersistenceException;
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void book() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

