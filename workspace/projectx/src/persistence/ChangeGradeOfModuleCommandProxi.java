package persistence;



import model.visitor.*;

public class ChangeGradeOfModuleCommandProxi extends PersistentProxi implements PersistentChangeGradeOfModuleCommand{
    
    public ChangeGradeOfModuleCommandProxi(long objectId) {
        super(objectId);
    }
    public ChangeGradeOfModuleCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 270;
    }
    
    public ModuleAtomarStudent4Public getModule() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getModule();
    }
    public void setModule(ModuleAtomarStudent4Public newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setModule(newValue);
    }
    public String getGrade() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getGrade();
    }
    public void setGrade(String newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setGrade(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudentManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public void accept(StudentManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R> R accept(StudentManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(StudentManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudentManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeGradeOfModuleCommand)this.getTheObject()).sendResult();
    }

    
}
