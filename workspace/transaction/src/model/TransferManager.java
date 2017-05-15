
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class TransferManager extends PersistentObject implements PersistentTransferManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static TransferManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.getClass(objectId);
        return (TransferManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static TransferManager4Public createTransferManager() throws PersistenceException{
        return createTransferManager(false);
    }
    
    public static TransferManager4Public createTransferManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentTransferManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
                .newDelayedTransferManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
                .newTransferManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static TransferManager4Public createTransferManager(boolean delayed$Persistence,TransferManager4Public This) throws PersistenceException {
        PersistentTransferManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
                .newDelayedTransferManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
                .newTransferManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("transfers", this.getTransfers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public TransferManager provideCopy() throws PersistenceException{
        TransferManager result = this;
        result = new TransferManager(this.subService, 
                                     this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected TransferManager_TransfersProxi transfers;
    protected SubjInterface subService;
    protected PersistentTransferManager This;
    
    public TransferManager(SubjInterface subService,PersistentTransferManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.transfers = new TransferManager_TransfersProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 114) ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade
            .newTransferManager(this.getId());
        super.store();
        this.getTransfers().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public TransferManager_TransfersProxi getTransfers() throws PersistenceException {
        return this.transfers;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentTransferManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTransferManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTransferManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransferManager result = (PersistentTransferManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransferManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransferManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransferManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransferManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransferManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransferManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransferManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransferManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransferManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTransfers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void book(final AbstractTransfer4Public tranfer, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		BookCommand4Public command = model.meta.BookCommand.createBookCommand(nw, d1170);
		command.setTranfer(tranfer);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createTransfer(final AccountHandle4Public fromAccount, final AccountHandle4Public toAccount, final common.Fraction amount, final String subject, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateTransferCommand4Public command = model.meta.CreateTransferCommand.createCreateTransferCommand(amount, subject, nw, d1170);
		command.setFromAccount(fromAccount);
		command.setToAccount(toAccount);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTransferManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void book(final AbstractTransfer4Public tranfer) 
				throws PersistenceException{
    	tranfer.book();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createTransfer(final AccountHandle4Public fromAccount, final AccountHandle4Public toAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException{
    	Transfer4Public newTransfer =
    			Transfer.createTransfer(subject, fromAccount.fetchAccount(), toAccount.fetchAccount(), amount);
    	getThis().getTransfers().add(newTransfer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
