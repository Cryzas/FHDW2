package persistence;



import model.visitor.*;

public class AddContaineeCommandProxi extends PersistentProxi implements PersistentAddContaineeCommand{
    
    public AddContaineeCommandProxi(long objectId) {
        super(objectId);
    }
    public AddContaineeCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 120;
    }
    
    public Containee4Public getContainee() throws PersistenceException {
        return ((PersistentAddContaineeCommand)this.getTheObject()).getContainee();
    }
    public void setContainee(Containee4Public newValue) throws PersistenceException {
        ((PersistentAddContaineeCommand)this.getTheObject()).setContainee(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddContaineeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddContaineeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public Directory4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAddContaineeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(Directory4Public newValue) throws PersistenceException {
        ((PersistentAddContaineeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddContaineeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddContaineeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddContaineeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddContaineeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddContaineeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddContaineeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddContaineeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddContaineeCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddContaineeCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddContaineeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddContaineeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddContaineeCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddContaineeCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddContaineeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddContaineeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddContaineeCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddContaineeCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddContaineeCommand(this);
    }
    public void accept(DirectoryCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddContaineeCommand(this);
    }
    public <R> R accept(DirectoryCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddContaineeCommand(this);
    }
    public <E extends model.UserException>  void accept(DirectoryCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddContaineeCommand(this);
    }
    public <R, E extends model.UserException> R accept(DirectoryCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddContaineeCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAddContaineeCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddContaineeCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddContaineeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddContaineeCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddContaineeCommand)this.getTheObject()).sendResult();
    }

    
}
