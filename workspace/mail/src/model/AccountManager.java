
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountManager extends PersistentObject implements PersistentAccountManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AccountManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getClass(objectId);
        return (AccountManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AccountManager4Public createAccountManager() throws PersistenceException{
        return createAccountManager(false);
    }
    
    public static AccountManager4Public createAccountManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newDelayedAccountManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newAccountManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static AccountManager4Public createAccountManager(boolean delayed$Persistence,AccountManager4Public This) throws PersistenceException {
        PersistentAccountManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newDelayedAccountManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newAccountManager(-1);
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
            result.put("accounts", this.getAccounts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AccountManager provideCopy() throws PersistenceException{
        AccountManager result = this;
        result = new AccountManager(this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected AccountManager_AccountsProxi accounts;
    protected PersistentAccountManager This;
    
    public AccountManager(PersistentAccountManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.accounts = new AccountManager_AccountsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 125) ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
            .newAccountManager(this.getId());
        super.store();
        this.getAccounts().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public AccountManager_AccountsProxi getAccounts() throws PersistenceException {
        return this.accounts;
    }
    protected void setThis(PersistentAccountManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountManager result = (PersistentAccountManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccountManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getAccounts().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addReceiver(final Draft4Public draft, final Account4Public account, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddReceiverCommand4Public command = model.meta.AddReceiverCommand.createAddReceiverCommand(nw, d1170);
		command.setDraft(draft);
		command.setAccount(account);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void answerAll(final MailEntry4Public mail, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AnswerAllCommand4Public command = model.meta.AnswerAllCommand.createAnswerAllCommand(subject, text, nw, d1170);
		command.setMail(mail);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void answer(final MailEntry4Public mail, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AnswerCommand4Public command = model.meta.AnswerCommand.createAnswerCommand(subject, text, nw, d1170);
		command.setMail(mail);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createAccount(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateAccountCommand4Public command = model.meta.CreateAccountCommand.createCreateAccountCommand(name, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createDraft(final Account4Public account, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateDraftCommand4Public command = model.meta.CreateDraftCommand.createCreateDraftCommand(subject, text, nw, d1170);
		command.setAccount(account);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createFolder(final Account4Public account, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateFolderCommand4Public command = model.meta.CreateFolderCommand.createCreateFolderCommand(name, nw, d1170);
		command.setAccount(account);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void send(final Draft4Public draft, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		SendCommand4Public command = model.meta.SendCommand.createSendCommand(nw, d1170);
		command.setDraft(draft);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addReceiver(final Draft4Public draft, final Account4Public account) 
				throws PersistenceException{
    	draft.addReceiver(account);
    }
    public void answerAll(final MailEntry4Public mail, final String subject, final String text) 
				throws PersistenceException{
    	mail.getParentFolder().applyToAll(folder -> folder.getParentAccount().getDrafts().addMail(mail.answerAll(subject, text, folder.getParentAccount().wrap())));
    }
    public void answer(final MailEntry4Public mail, final String subject, final String text) 
				throws PersistenceException{
    	mail.getParentFolder().applyToAll(folder -> folder.getParentAccount().getDrafts().addMail(mail.answer(subject, text, folder.getParentAccount().wrap())));
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createAccount(final String name) 
				throws PersistenceException{
    	getThis().getAccounts().add(Account.createAccount(name));
    }
    public void createDraft(final Account4Public account, final String subject, final String text) 
				throws PersistenceException{
    	account.createDraft(subject, text);
        
    }
    public void createFolder(final Account4Public account, final String name) 
				throws PersistenceException{
    	account.createFolder(name);
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void send(final Draft4Public draft) 
				throws PersistenceException{
    	draft.getSender().send(draft);
    	draft.getReceivers().applyToAll(receiver -> receiver.receive(draft.send()));
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
