package persistence;



import model.visitor.*;

public class EndStudyGroupCommandProxi extends PersistentProxi implements PersistentEndStudyGroupCommand{
    
    public EndStudyGroupCommandProxi(long objectId) {
        super(objectId);
    }
    public EndStudyGroupCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 284;
    }
    
    public StudyGroup4Public getStudyGroup() throws PersistenceException {
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).getStudyGroup();
    }
    public void setStudyGroup(StudyGroup4Public newValue) throws PersistenceException {
        ((PersistentEndStudyGroupCommand)this.getTheObject()).setStudyGroup(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentEndStudyGroupCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudyGroupManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudyGroupManager4Public newValue) throws PersistenceException {
        ((PersistentEndStudyGroupCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentEndStudyGroupCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentEndStudyGroupCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentEndStudyGroupCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleEndStudyGroupCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEndStudyGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEndStudyGroupCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEndStudyGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public void accept(StudyGroupManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleEndStudyGroupCommand(this);
    }
    public <R> R accept(StudyGroupManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(StudyGroupManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEndStudyGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudyGroupManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleEndStudyGroupCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEndStudyGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEndStudyGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEndStudyGroupCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentEndStudyGroupCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentEndStudyGroupCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentEndStudyGroupCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentEndStudyGroupCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentEndStudyGroupCommand)this.getTheObject()).sendResult();
    }

    
}
