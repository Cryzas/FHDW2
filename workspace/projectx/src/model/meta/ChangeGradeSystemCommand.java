
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ChangeGradeSystemCommand extends PersistentObject implements PersistentChangeGradeSystemCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ChangeGradeSystemCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.getClass(objectId);
        return (ChangeGradeSystemCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ChangeGradeSystemCommand4Public createChangeGradeSystemCommand(String gradeSystem,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createChangeGradeSystemCommand(gradeSystem,createDate,commitDate,false);
    }
    
    public static ChangeGradeSystemCommand4Public createChangeGradeSystemCommand(String gradeSystem,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (gradeSystem == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentChangeGradeSystemCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade
                .newDelayedChangeGradeSystemCommand(gradeSystem);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade
                .newChangeGradeSystemCommand(gradeSystem,-1);
        }
        ((PersistentChangeGradeSystemCommand)result).setMyCommonDate((PersistentCommonDate)CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentModuleAtomar module;
    protected String gradeSystem;
    protected Invoker invoker;
    protected PersistentModuleManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public ChangeGradeSystemCommand(PersistentModuleAtomar module,String gradeSystem,Invoker invoker,PersistentModuleManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.module = module;
        this.gradeSystem = gradeSystem;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 211;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 211) ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade
            .newChangeGradeSystemCommand(gradeSystem,this.getId());
        super.store();
        if(this.getModule() != null){
            this.getModule().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.moduleSet(this.getId(), getModule());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public ModuleAtomar4Public getModule() throws PersistenceException {
        return this.module;
    }
    public void setModule(ModuleAtomar4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.module)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.module = (PersistentModuleAtomar)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.moduleSet(this.getId(), newValue);
        }
    }
    public String getGradeSystem() throws PersistenceException {
        return this.gradeSystem;
    }
    public void setGradeSystem(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.gradeSystemSet(this.getId(), newValue);
        this.gradeSystem = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public ModuleManager4Public getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(ModuleManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentModuleManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theChangeGradeSystemCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleChangeGradeSystemCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeSystemCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeSystemCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeSystemCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeSystemCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeSystemCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public void accept(ModuleManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeSystemCommand(this);
    }
    public <R> R accept(ModuleManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public <E extends model.UserException>  void accept(ModuleManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeSystemCommand(this);
    }
    public <R, E extends model.UserException> R accept(ModuleManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeSystemCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModule() != null) return 1;
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
			this.commandReceiver.changeGradeSystem(this.getModule(), this.getGradeSystem());
		}
		catch(model.invalidGradeSysteException e){
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
