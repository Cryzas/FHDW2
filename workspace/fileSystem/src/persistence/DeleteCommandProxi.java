package persistence;



import model.visitor.*;

public class DeleteCommandProxi extends PersistentProxi implements PersistentDeleteCommand{
    
    public DeleteCommandProxi(long objectId) {
        super(objectId);
    }
    public DeleteCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 125;
    }
    
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentDeleteCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentDeleteCommand)this.getTheObject()).setInvoker(newValue);
    }
    public Containee4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentDeleteCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(Containee4Public newValue) throws PersistenceException {
        ((PersistentDeleteCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentDeleteCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentDeleteCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentDeleteCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentDeleteCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentDeleteCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentDeleteCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleDeleteCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDeleteCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleDeleteCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteCommand(this);
    }
    public void accept(ContaineeCommandVisitor visitor) throws PersistenceException {
        visitor.handleDeleteCommand(this);
    }
    public <R> R accept(ContaineeCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteCommand(this);
    }
    public <E extends model.UserException>  void accept(ContaineeCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteCommand(this);
    }
    public <R, E extends model.UserException> R accept(ContaineeCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentDeleteCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentDeleteCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentDeleteCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentDeleteCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentDeleteCommand)this.getTheObject()).sendResult();
    }

    
}
