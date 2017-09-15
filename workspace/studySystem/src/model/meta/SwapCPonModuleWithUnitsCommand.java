
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class SwapCPonModuleWithUnitsCommand extends PersistentObject implements PersistentSwapCPonModuleWithUnitsCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static SwapCPonModuleWithUnitsCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.getClass(objectId);
        return (SwapCPonModuleWithUnitsCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static SwapCPonModuleWithUnitsCommand4Public createSwapCPonModuleWithUnitsCommand(common.Fraction creditPoints,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createSwapCPonModuleWithUnitsCommand(creditPoints,createDate,commitDate,false);
    }
    
    public static SwapCPonModuleWithUnitsCommand4Public createSwapCPonModuleWithUnitsCommand(common.Fraction creditPoints,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentSwapCPonModuleWithUnitsCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade
                .newDelayedSwapCPonModuleWithUnitsCommand(creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade
                .newSwapCPonModuleWithUnitsCommand(creditPoints,-1);
        }
        ((PersistentSwapCPonModuleWithUnitsCommand)result).setMyCommonDate((PersistentCommonDate)CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentModuleWithUnitsSGroup module;
    protected PersistentUnitSGroup fromUnit;
    protected PersistentUnitSGroup ToUnit;
    protected common.Fraction creditPoints;
    protected Invoker invoker;
    protected PersistentStudyGroupManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public SwapCPonModuleWithUnitsCommand(PersistentModuleWithUnitsSGroup module,PersistentUnitSGroup fromUnit,PersistentUnitSGroup ToUnit,common.Fraction creditPoints,Invoker invoker,PersistentStudyGroupManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.module = module;
        this.fromUnit = fromUnit;
        this.ToUnit = ToUnit;
        this.creditPoints = creditPoints;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 188;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 188) ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade
            .newSwapCPonModuleWithUnitsCommand(creditPoints,this.getId());
        super.store();
        if(this.getModule() != null){
            this.getModule().store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.moduleSet(this.getId(), getModule());
        }
        if(this.getFromUnit() != null){
            this.getFromUnit().store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.fromUnitSet(this.getId(), getFromUnit());
        }
        if(this.getToUnit() != null){
            this.getToUnit().store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.ToUnitSet(this.getId(), getToUnit());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public ModuleWithUnitsSGroup4Public getModule() throws PersistenceException {
        return this.module;
    }
    public void setModule(ModuleWithUnitsSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.module)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.moduleSet(this.getId(), newValue);
        }
    }
    public UnitSGroup4Public getFromUnit() throws PersistenceException {
        return this.fromUnit;
    }
    public void setFromUnit(UnitSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.fromUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromUnit = (PersistentUnitSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.fromUnitSet(this.getId(), newValue);
        }
    }
    public UnitSGroup4Public getToUnit() throws PersistenceException {
        return this.ToUnit;
    }
    public void setToUnit(UnitSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.ToUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ToUnit = (PersistentUnitSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.ToUnitSet(this.getId(), newValue);
        }
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return this.creditPoints;
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.creditPointsSet(this.getId(), newValue);
        this.creditPoints = newValue;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public StudyGroupManager4Public getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(StudyGroupManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentStudyGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getModule() != null) return 1;
        if (this.getFromUnit() != null) return 1;
        if (this.getToUnit() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains operations that must be implemented.
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.commandReceiver.swapCPonModuleWithUnits(this.getModule(), this.getFromUnit(), this.getToUnit(), this.getCreditPoints());
		}
		catch(model.UnitSwapException e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
