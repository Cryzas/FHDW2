package persistence;



import model.visitor.*;

public class SwapCPonModuleWithUnitsCommandICProxi extends PersistentInCacheProxi implements PersistentSwapCPonModuleWithUnitsCommand{
    
    public SwapCPonModuleWithUnitsCommandICProxi(long objectId) {
        super(objectId);
    }
    public SwapCPonModuleWithUnitsCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade
            .getSwapCPonModuleWithUnitsCommand(this.getId());
    }
    
    public long getClassId() {
        return 188;
    }
    
    public ModuleWithUnitsSGroup4Public getModule() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getModule();
    }
    public void setModule(ModuleWithUnitsSGroup4Public newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setModule(newValue);
    }
    public UnitSGroup4Public getFromUnit() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getFromUnit();
    }
    public void setFromUnit(UnitSGroup4Public newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setFromUnit(newValue);
    }
    public UnitSGroup4Public getToUnit() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getToUnit();
    }
    public void setToUnit(UnitSGroup4Public newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setToUnit(newValue);
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setCreditPoints(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudyGroupManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudyGroupManager4Public newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public void accept(StudyGroupManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R> R accept(StudyGroupManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <E extends model.UserException>  void accept(StudyGroupManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudyGroupManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSwapCPonModuleWithUnitsCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentSwapCPonModuleWithUnitsCommand)this.getTheObject()).sendResult();
    }

    
}
