
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Draft extends model.Mail implements PersistentDraft{
    
    
    public static Draft4Public createDraft(String subject,String text,AccountWrapper4Public sender) throws PersistenceException{
        return createDraft(subject,text,sender,false);
    }
    
    public static Draft4Public createDraft(String subject,String text,AccountWrapper4Public sender,boolean delayed$Persistence) throws PersistenceException {
        PersistentDraft result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDraftFacade
                .newDelayedDraft(subject,text);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDraftFacade
                .newDraft(subject,text,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        final$$Fields.put("text", text);
        final$$Fields.put("sender", sender);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Draft4Public createDraft(String subject,String text,AccountWrapper4Public sender,boolean delayed$Persistence,Draft4Public This) throws PersistenceException {
        PersistentDraft result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDraftFacade
                .newDelayedDraft(subject,text);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDraftFacade
                .newDraft(subject,text,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        final$$Fields.put("text", text);
        final$$Fields.put("sender", sender);
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
    
    public Draft provideCopy() throws PersistenceException{
        Draft result = this;
        result = new Draft(this.subject, 
                           this.text, 
                           this.This, 
                           this.sender, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountWrapper sender;
    
    public Draft(String subject,String text,PersistentMail This,PersistentAccountWrapper sender,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)subject,(String)text,(PersistentMail)This,id);
        this.sender = sender;        
    }
    
    static public long getTypeId() {
        return 133;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 133) ConnectionHandler.getTheConnectionHandler().theDraftFacade
            .newDraft(subject,text,this.getId());
        super.store();
        if(this.getSender() != null){
            this.getSender().store();
            ConnectionHandler.getTheConnectionHandler().theDraftFacade.senderSet(this.getId(), getSender());
        }
        
    }
    
    public AccountWrapper4Public getSender() throws PersistenceException {
        return this.sender;
    }
    public void setSender(AccountWrapper4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.sender)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.sender = (PersistentAccountWrapper)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDraftFacade.senderSet(this.getId(), newValue);
        }
    }
    public PersistentDraft getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDraft result = (PersistentDraft)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentDraft)this.This;
    }
    
    public void accept(MailVisitor visitor) throws PersistenceException {
        visitor.handleDraft(this);
    }
    public <R> R accept(MailReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDraft(this);
    }
    public <E extends model.UserException>  void accept(MailExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDraft(this);
    }
    public <R, E extends model.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDraft(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDraft(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDraft(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDraft(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDraft(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getReceivers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDraft)This);
		if(this.isTheSameAs(This)){
			this.setSubject((String)final$$Fields.get("subject"));
			this.setText((String)final$$Fields.get("text"));
			this.setSender((PersistentAccountWrapper)final$$Fields.get("sender"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addReceiver(final Account4Public account) 
				throws PersistenceException{
    	getThis().getReceivers().add(account.wrap());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public MailEntry4Public send() 
				throws PersistenceException{
        MailEntry4Public mailEntry = MailEntry.createMailEntry(getThis().getSubject(), getThis().getText(), getThis().getSender());
        getThis().getReceivers().applyToAll(receiver -> mailEntry.getReceivers().add(receiver));
        return mailEntry;
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
