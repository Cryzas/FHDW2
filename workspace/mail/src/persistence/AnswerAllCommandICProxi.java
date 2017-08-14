package persistence;



import model.visitor.*;

public class AnswerAllCommandICProxi extends PersistentInCacheProxi implements PersistentAnswerAllCommand{
    
    public AnswerAllCommandICProxi(long objectId) {
        super(objectId);
    }
    public AnswerAllCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAnswerAllCommandFacade
            .getAnswerAllCommand(this.getId());
    }
    
    public long getClassId() {
        return 142;
    }
    
    public MailEntry4Public getMail() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getMail();
    }
    public void setMail(MailEntry4Public newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setMail(newValue);
    }
    public String getSubject() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setSubject(newValue);
    }
    public String getText() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getText();
    }
    public void setText(String newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setText(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AccountManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AccountManager4Public newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAnswerAllCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAnswerAllCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAnswerAllCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerAllCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerAllCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerAllCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAnswerAllCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerAllCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerAllCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerAllCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAnswerAllCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerAllCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerAllCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerAllCommand(this);
    }
    public void accept(AccountManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAnswerAllCommand(this);
    }
    public <R> R accept(AccountManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerAllCommand(this);
    }
    public <E extends model.UserException>  void accept(AccountManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerAllCommand(this);
    }
    public <R, E extends model.UserException> R accept(AccountManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerAllCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAnswerAllCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAnswerAllCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAnswerAllCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAnswerAllCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAnswerAllCommand)this.getTheObject()).sendResult();
    }

    
}
