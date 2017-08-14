package persistence;



import model.visitor.*;

public class ChangeCPOnModuleCommandProxi extends PersistentProxi implements PersistentChangeCPOnModuleCommand{
    
    public ChangeCPOnModuleCommandProxi(long objectId) {
        super(objectId);
    }
    public ChangeCPOnModuleCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 156;
    }
    
    public ModuleAtomar4Public getModule() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getModule();
    }
    public void setModule(ModuleAtomar4Public newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setModule(newValue);
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setCreditPoints(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setInvoker(newValue);
    }
    public ModuleManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(ModuleManager4Public newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public void accept(ModuleManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R> R accept(ModuleManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    public <E extends model.UserException>  void accept(ModuleManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeCPOnModuleCommand(this);
    }
    public <R, E extends model.UserException> R accept(ModuleManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeCPOnModuleCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeCPOnModuleCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeCPOnModuleCommand)this.getTheObject()).sendResult();
    }

    
}
