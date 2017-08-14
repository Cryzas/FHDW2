package persistence;



import model.visitor.*;

public class AddModuleCommandICProxi extends PersistentInCacheProxi implements PersistentAddModuleCommand{
    
    public AddModuleCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddModuleCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddModuleCommandFacade
            .getAddModuleCommand(this.getId());
    }
    
    public long getClassId() {
        return 160;
    }
    
    public Program4Public getProgram() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getProgram();
    }
    public void setProgram(Program4Public newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setProgram(newValue);
    }
    public ModuleAbstract4Public getModule() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getModule();
    }
    public void setModule(ModuleAbstract4Public newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setModule(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setInvoker(newValue);
    }
    public ProgramManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(ProgramManager4Public newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddModuleCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddModuleCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddModuleCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddModuleCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddModuleCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddModuleCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddModuleCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddModuleCommand(this);
    }
    public void accept(ProgramManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddModuleCommand(this);
    }
    public <R> R accept(ProgramManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(ProgramManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(ProgramManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddModuleCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAddModuleCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddModuleCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddModuleCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddModuleCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddModuleCommand)this.getTheObject()).sendResult();
    }

    
}
