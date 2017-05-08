package persistence;



import model.visitor.*;

public class CreateTransferCommandICProxi extends PersistentInCacheProxi implements PersistentCreateTransferCommand{
    
    public CreateTransferCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateTransferCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateTransferCommandFacade
            .getCreateTransferCommand(this.getId());
    }
    
    public long getClassId() {
        return 136;
    }
    
    public Account4Public getFromAcc() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getFromAcc();
    }
    public void setFromAcc(Account4Public newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setFromAcc(newValue);
    }
    public Account4Public getToAcc() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getToAcc();
    }
    public void setToAcc(Account4Public newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setToAcc(newValue);
    }
    public String getDescription() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setAmount(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setInvoker(newValue);
    }
    public Manager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(Manager4Public newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateTransferCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateTransferCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateTransferCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateTransferCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateTransferCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateTransferCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateTransferCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateTransferCommand(this);
    }
    public void accept(ManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateTransferCommand(this);
    }
    public <R> R accept(ManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateTransferCommand(this);
    }
    public <E extends model.UserException>  void accept(ManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateTransferCommand(this);
    }
    public <R, E extends model.UserException> R accept(ManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateTransferCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentCreateTransferCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateTransferCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateTransferCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateTransferCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateTransferCommand)this.getTheObject()).sendResult();
    }

    
}
