package persistence;



import model.visitor.*;

public class CreateStudentCommandICProxi extends PersistentInCacheProxi implements PersistentCreateStudentCommand{
    
    public CreateStudentCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateStudentCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade
            .getCreateStudentCommand(this.getId());
    }
    
    public long getClassId() {
        return 200;
    }
    
    public StudyGroup4Public getGroup() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getGroup();
    }
    public void setGroup(StudyGroup4Public newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setGroup(newValue);
    }
    public String getFirstName() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getFirstName();
    }
    public void setFirstName(String newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setFirstName(newValue);
    }
    public String getLastName() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getLastName();
    }
    public void setLastName(String newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setLastName(newValue);
    }
    public java.sql.Date getBirthDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getBirthDate();
    }
    public void setBirthDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setBirthDate(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudyGroupManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudyGroupManager4Public newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(StudyGroupManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(StudyGroupManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(StudyGroupManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudyGroupManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateStudentCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).sendResult();
    }

    
}
