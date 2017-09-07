package persistence;



import model.visitor.*;

public class ChangeGradeCommandICProxi extends PersistentInCacheProxi implements PersistentChangeGradeCommand{
    
    public ChangeGradeCommandICProxi(long objectId) {
        super(objectId);
    }
    public ChangeGradeCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade
            .getChangeGradeCommand(this.getId());
    }
    
    public long getClassId() {
        return 275;
    }
    
    public LectureWithGrade getLecture() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getLecture();
    }
    public void setLecture(LectureWithGrade newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setLecture(newValue);
    }
    public String getGrade() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getGrade();
    }
    public void setGrade(String newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setGrade(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudentManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeGradeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeGradeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public void accept(StudentManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(StudentManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(StudentManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudentManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentChangeGradeCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeGradeCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeGradeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeGradeCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeGradeCommand)this.getTheObject()).sendResult();
    }

    
}
