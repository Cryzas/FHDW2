package persistence;



import model.visitor.*;

public class CreateFolderCommandICProxi extends PersistentInCacheProxi implements PersistentCreateFolderCommand{
    
    public CreateFolderCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateFolderCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateFolderCommandFacade
            .getCreateFolderCommand(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public Account4Public getAccount() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getAccount();
    }
    public void setAccount(Account4Public newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setAccount(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AccountManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AccountManager4Public newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateFolderCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateFolderCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateFolderCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateFolderCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateFolderCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateFolderCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateFolderCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateFolderCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateFolderCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateFolderCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateFolderCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateFolderCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateFolderCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateFolderCommand(this);
    }
    public void accept(AccountManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateFolderCommand(this);
    }
    public <R> R accept(AccountManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateFolderCommand(this);
    }
    public <E extends model.UserException>  void accept(AccountManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateFolderCommand(this);
    }
    public <R, E extends model.UserException> R accept(AccountManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateFolderCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentCreateFolderCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateFolderCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateFolderCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateFolderCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateFolderCommand)this.getTheObject()).sendResult();
    }

    
}
