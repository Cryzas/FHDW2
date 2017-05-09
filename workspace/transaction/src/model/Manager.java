
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Manager extends PersistentObject implements PersistentManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Manager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theManagerFacade.getClass(objectId);
        return (Manager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Manager4Public createManager() throws PersistenceException{
        return createManager(false);
    }
    
    public static Manager4Public createManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theManagerFacade
                .newDelayedManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theManagerFacade
                .newManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Manager4Public createManager(boolean delayed$Persistence,Manager4Public This) throws PersistenceException {
        PersistentManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theManagerFacade
                .newDelayedManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theManagerFacade
                .newManager(-1);
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
            result.put("currentAccounts", this.getCurrentAccounts().getValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            result.put("openTransfers", this.getOpenTransfers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Manager provideCopy() throws PersistenceException{
        Manager result = this;
        result = new Manager(this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Manager_CurrentAccountsProxi currentAccounts;
    protected Manager_OpenTransfersProxi openTransfers;
    protected PersistentManager This;
    
    public Manager(PersistentManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.currentAccounts = new Manager_CurrentAccountsProxi(this);
        this.openTransfers = new Manager_OpenTransfersProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 135) ConnectionHandler.getTheConnectionHandler().theManagerFacade
            .newManager(this.getId());
        super.store();
        this.getCurrentAccounts().store();
        this.getOpenTransfers().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Manager_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException {
        return this.currentAccounts;
    }
    public Manager_OpenTransfersProxi getOpenTransfers() throws PersistenceException {
        return this.openTransfers;
    }
    protected void setThis(PersistentManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentManager result = (PersistentManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getOpenTransfers().getLength() > 0) return 1;
        if( this.getCurrentAccounts().getValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void book(final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		BookCommand4Public command = model.meta.BookCommand.createBookCommand(nw, d1170);
		command.setTransfer(transfer);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createAccount(final String description, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateAccountCommand4Public command = model.meta.CreateAccountCommand.createCreateAccountCommand(description, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createTransfer(final Account4Public fromAcc, final Account4Public toAcc, final String description, final common.Fraction amount, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateTransferCommand4Public command = model.meta.CreateTransferCommand.createCreateTransferCommand(description, amount, nw, d1170);
		command.setFromAcc(fromAcc);
		command.setToAcc(toAcc);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void book(final Transfer4Public transfer) 
				throws PersistenceException{
        transfer.book();
        getThis().getOpenTransfers().filter(arg -> !arg.equals(transfer));
    }
    public void clearAccounts() 
				throws PersistenceException{   
		getThis().getCurrentAccounts().filter(arg -> false);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createAccount(final String description) 
				throws PersistenceException{
    	getThis().getCurrentAccounts().put(description, Account.createAccount(description));
        
    }
    public void createTransfer(final Account4Public fromAcc, final Account4Public toAcc, final String description, final common.Fraction amount) 
				throws PersistenceException{
    	getThis().getOpenTransfers().add(Transfer.createTransfer(description, amount, fromAcc, toAcc));
        
    }
    public void findAccountByName(final String name) 
				throws PersistenceException{
    	Account.getAccountByDescription(name).applyToAll(this::addIfNotExists);
    }
    public void findAccountByNumber(final long number) 
				throws PersistenceException{
    	addIfNotExists(Account.getById(number));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    private void addIfNotExists(Account4Public toBeAdded) throws PersistenceException {
    	if (getThis().getCurrentAccounts().get(toBeAdded.getDescription()) == null) {
			getThis().getCurrentAccounts().put(toBeAdded.getDescription(), toBeAdded);
		}
    }
    
    /* End of protected part that is not overridden by persistence generator */
    
}
