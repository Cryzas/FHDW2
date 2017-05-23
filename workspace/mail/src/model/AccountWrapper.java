
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountWrapper extends model.abstractAcc implements PersistentAccountWrapper{
    
    
    public static AccountWrapper4Public createAccountWrapper(String name,Account4Public wrapped) throws PersistenceException{
        return createAccountWrapper(name,wrapped,false);
    }
    
    public static AccountWrapper4Public createAccountWrapper(String name,Account4Public wrapped,boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade
                .newDelayedAccountWrapper(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade
                .newAccountWrapper(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("wrapped", wrapped);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static AccountWrapper4Public createAccountWrapper(String name,Account4Public wrapped,boolean delayed$Persistence,AccountWrapper4Public This) throws PersistenceException {
        PersistentAccountWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade
                .newDelayedAccountWrapper(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade
                .newAccountWrapper(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("wrapped", wrapped);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AccountWrapper provideCopy() throws PersistenceException{
        AccountWrapper result = this;
        result = new AccountWrapper(this.name, 
                                    this.This, 
                                    this.wrapped, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount wrapped;
    
    public AccountWrapper(String name,PersistentabstractAcc This,PersistentAccount wrapped,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentabstractAcc)This,id);
        this.wrapped = wrapped;        
    }
    
    static public long getTypeId() {
        return 139;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 139) ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade
            .newAccountWrapper(name,this.getId());
        super.store();
        if(this.getWrapped() != null){
            this.getWrapped().store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade.wrappedSet(this.getId(), getWrapped());
        }
        
    }
    
    public Account4Public getWrapped() throws PersistenceException {
        return this.wrapped;
    }
    public void setWrapped(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.wrapped)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.wrapped = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade.wrappedSet(this.getId(), newValue);
        }
    }
    public PersistentAccountWrapper getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountWrapper result = (PersistentAccountWrapper)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccountWrapper)this.This;
    }
    
    public void accept(abstractAccVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrapper(this);
    }
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrapper(this);
    }
    public <E extends model.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrapper(this);
    }
    public <R, E extends model.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrapper(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrapper(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrapper(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrapper(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountWrapper)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setWrapped((PersistentAccount)final$$Fields.get("wrapped"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public Account4Public wrappedAcc() 
				throws PersistenceException{
        return getThis().getWrapped();
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void createDraft(final String subject, final String text) 
				throws PersistenceException{
		getThis().getWrapped().createDraft(subject, text);		
	}
    public void createFolder(final String name) 
				throws PersistenceException{
		getThis().getWrapped().createFolder(name);
		
	}
    public void receive(final MailEntry4Public mail) 
				throws PersistenceException{
		getThis().getWrapped().receive(mail);
	}
    public void send(final Draft4Public draft) 
				throws PersistenceException{
		getThis().getWrapped().send(draft);
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
