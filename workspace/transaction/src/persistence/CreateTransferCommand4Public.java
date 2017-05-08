package persistence;


import model.visitor.*;

public interface CreateTransferCommand4Public extends Anything, ManagerCommand, CommonDate4Public, AbstractPersistentProxi {
    
    public Account4Public getFromAcc() throws PersistenceException ;
    public void setFromAcc(Account4Public newValue) throws PersistenceException ;
    public Account4Public getToAcc() throws PersistenceException ;
    public void setToAcc(Account4Public newValue) throws PersistenceException ;
    public String getDescription() throws PersistenceException ;
    public void setDescription(String newValue) throws PersistenceException ;
    public common.Fraction getAmount() throws PersistenceException ;
    public void setAmount(common.Fraction newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public Manager4Public getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(Manager4Public newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void checkException() 
				throws model.UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

}

