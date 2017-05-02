
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AddPartCommand extends PersistentObject implements PersistentAddPartCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AddPartCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.getClass(objectId);
        return (AddPartCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AddPartCommand4Public createAddPartCommand(long quantity,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createAddPartCommand(quantity,createDate,commitDate,false);
    }
    
    public static AddPartCommand4Public createAddPartCommand(long quantity,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentAddPartCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade
                .newDelayedAddPartCommand(quantity);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade
                .newAddPartCommand(quantity,-1);
        }
        ((PersistentAddPartCommand)result).setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentComponent component;
    protected long quantity;
    protected Invoker invoker;
    protected PersistentProduct commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public AddPartCommand(PersistentComponent component,long quantity,Invoker invoker,PersistentProduct commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.component = component;
        this.quantity = quantity;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 120) ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade
            .newAddPartCommand(quantity,this.getId());
        super.store();
        if(this.getComponent() != null){
            this.getComponent().store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.componentSet(this.getId(), getComponent());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public Component4Public getComponent() throws PersistenceException {
        return this.component;
    }
    public void setComponent(Component4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.component)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.component = (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.componentSet(this.getId(), newValue);
        }
    }
    public long getQuantity() throws PersistenceException {
        return this.quantity;
    }
    public void setQuantity(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.quantitySet(this.getId(), newValue);
        this.quantity = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public Product4Public getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(Product4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public void accept(ProductCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(ProductCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(ProductCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(ProductCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getComponent() != null) return 1;
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
			this.commandReceiver.addPart(this.getComponent(), this.getQuantity());
		}
		catch(model.PartsListException e){
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
