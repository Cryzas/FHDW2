package persistence;


import model.visitor.*;

public interface GradesInTenth4Public extends Grade4Public {
    
    
    public void accept(GradesInTenthVisitor visitor) throws PersistenceException;
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

