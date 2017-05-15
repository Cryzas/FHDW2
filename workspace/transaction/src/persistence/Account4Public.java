package persistence;


import model.visitor.*;

public interface Account4Public extends AccountHandle4Public {
    
    public String getName() throws PersistenceException ;
    public common.Fraction getBalance() throws PersistenceException ;
    public Account_EntriesProxi getEntries() throws PersistenceException ;
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void credit(final Transfer4Public transfer) 
				throws PersistenceException;
    public void debit(final Transfer4Public transfer) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

