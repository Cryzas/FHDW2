package persistence;



import model.visitor.*;

public class ChangeContentsCommandICProxi extends PersistentInCacheProxi implements PersistentChangeContentsCommand{
    
    public ChangeContentsCommandICProxi(long objectId) {
        super(objectId);
    }
    public ChangeContentsCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theChangeContentsCommandFacade
            .getChangeContentsCommand(this.getId());
    }
    
    public long getClassId() {
        return 121;
    }
    
    public String getNewContents() throws PersistenceException {
        return ((PersistentChangeContentsCommand)this.getTheObject()).getNewContents();
    }
    public void setNewContents(String newValue) throws PersistenceException {
        ((PersistentChangeContentsCommand)this.getTheObject()).setNewContents(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeContentsCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeContentsCommand)this.getTheObject()).setInvoker(newValue);
    }
    public File4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeContentsCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(File4Public newValue) throws PersistenceException {
        ((PersistentChangeContentsCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeContentsCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeContentsCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeContentsCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeContentsCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeContentsCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeContentsCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeContentsCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeContentsCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeContentsCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeContentsCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeContentsCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeContentsCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeContentsCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeContentsCommand(this);
    }
    public void accept(FileCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeContentsCommand(this);
    }
    public <R> R accept(FileCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeContentsCommand(this);
    }
    public <E extends model.UserException>  void accept(FileCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeContentsCommand(this);
    }
    public <R, E extends model.UserException> R accept(FileCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeContentsCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeContentsCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeContentsCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeContentsCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeContentsCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentChangeContentsCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeContentsCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeContentsCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeContentsCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeContentsCommand)this.getTheObject()).sendResult();
    }

    
}
