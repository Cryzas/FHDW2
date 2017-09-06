package persistence;



import model.visitor.*;

public class ChangeGradeOfModuleThirdCommandICProxi extends PersistentInCacheProxi implements PersistentChangeGradeOfModuleThirdCommand{
    
    public ChangeGradeOfModuleThirdCommandICProxi(long objectId) {
        super(objectId);
    }
    public ChangeGradeOfModuleThirdCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theChangeGradeOfModuleThirdCommandFacade
            .getChangeGradeOfModuleThirdCommand(this.getId());
    }
    
    public long getClassId() {
        return 266;
    }
    
    public ModuleAtomarStudent4Public getModule() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getModule();
    }
    public void setModule(ModuleAtomarStudent4Public newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setModule(newValue);
    }
    public String getGrade() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getGrade();
    }
    public void setGrade(String newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setGrade(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudentManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public void accept(StudentManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R> R accept(StudentManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <E extends model.UserException>  void accept(StudentManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudentManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeOfModuleThirdCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeGradeOfModuleThirdCommand)this.getTheObject()).sendResult();
    }

    
}
