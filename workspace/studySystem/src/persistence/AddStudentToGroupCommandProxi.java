package persistence;



import model.visitor.*;

public class AddStudentToGroupCommandProxi extends PersistentProxi implements PersistentAddStudentToGroupCommand{
    
    public AddStudentToGroupCommandProxi(long objectId) {
        super(objectId);
    }
    public AddStudentToGroupCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 203;
    }
    
    public StudyGroup4Public getGroup() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getGroup();
    }
    public void setGroup(StudyGroup4Public newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setGroup(newValue);
    }
    public Student4Public getStudent() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getStudent();
    }
    public void setStudent(Student4Public newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setStudent(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudentManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddStudentToGroupCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddStudentToGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddStudentToGroupCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddStudentToGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddStudentToGroupCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddStudentToGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public void accept(StudentManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddStudentToGroupCommand(this);
    }
    public <R> R accept(StudentManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    public <E extends model.UserException>  void accept(StudentManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddStudentToGroupCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudentManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddStudentToGroupCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddStudentToGroupCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddStudentToGroupCommand)this.getTheObject()).sendResult();
    }

    
}
