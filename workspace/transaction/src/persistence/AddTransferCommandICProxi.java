package persistence;



import model.visitor.*;

public class AddTransferCommandICProxi extends PersistentInCacheProxi implements PersistentAddTransferCommand{
    
    public AddTransferCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddTransferCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddTransferCommandFacade
            .getAddTransferCommand(this.getId());
    }
    
    public long getClassId() {
        return 137;
    }
    
    public Transaction4Public getTransaction() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getTransaction();
    }
    public void setTransaction(Transaction4Public newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setTransaction(newValue);
    }
    public Transfer4Public getTransfer() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getTransfer();
    }
    public void setTransfer(Transfer4Public newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setTransfer(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setInvoker(newValue);
    }
    public TransferManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(TransferManager4Public newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddTransferCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddTransferCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddTransferCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddTransferCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddTransferCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddTransferCommand(this);
    }
    public void accept(TransferManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddTransferCommand(this);
    }
    public <R> R accept(TransferManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(TransferManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(TransferManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddTransferCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddTransferCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddTransferCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAddTransferCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddTransferCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddTransferCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddTransferCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddTransferCommand)this.getTheObject()).sendResult();
    }

    
}
