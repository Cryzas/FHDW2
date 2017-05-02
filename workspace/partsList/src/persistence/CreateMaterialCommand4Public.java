package persistence;


import model.visitor.*;

public interface CreateMaterialCommand4Public extends PartsListManagerCommand, Anything, CommonDate4Public, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public common.Fraction getPrice() throws PersistenceException ;
    public void setPrice(common.Fraction newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public PartsListManager4Public getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(PartsListManager4Public newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(PartsListManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(PartsListManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(PartsListManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(PartsListManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void checkException() 
				throws model.UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

}

