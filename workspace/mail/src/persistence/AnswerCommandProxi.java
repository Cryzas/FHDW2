package persistence;



import model.visitor.*;

public class AnswerCommandProxi extends PersistentProxi implements PersistentAnswerCommand{
    
    public AnswerCommandProxi(long objectId) {
        super(objectId);
    }
    public AnswerCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 141;
    }
    
    public MailEntry4Public getMail() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getMail();
    }
    public void setMail(MailEntry4Public newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setMail(newValue);
    }
    public String getSubject() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setSubject(newValue);
    }
    public String getText() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getText();
    }
    public void setText(String newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setText(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AccountManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AccountManager4Public newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAnswerCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAnswerCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAnswerCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAnswerCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAnswerCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerCommand(this);
    }
    public void accept(AccountManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAnswerCommand(this);
    }
    public <R> R accept(AccountManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAnswerCommand(this);
    }
    public <E extends model.UserException>  void accept(AccountManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAnswerCommand(this);
    }
    public <R, E extends model.UserException> R accept(AccountManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAnswerCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAnswerCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAnswerCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAnswerCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAnswerCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAnswerCommand)this.getTheObject()).sendResult();
    }

    
}
