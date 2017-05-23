
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MailEntry extends model.Mail implements PersistentMailEntry{
    
    
    public static MailEntry4Public createMailEntry(String subject,String text,AccountWrapper4Public sender) throws PersistenceException{
        return createMailEntry(subject,text,sender,false);
    }
    
    public static MailEntry4Public createMailEntry(String subject,String text,AccountWrapper4Public sender,boolean delayed$Persistence) throws PersistenceException {
        PersistentMailEntry result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMailEntryFacade
                .newDelayedMailEntry(subject,text);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMailEntryFacade
                .newMailEntry(subject,text,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        final$$Fields.put("text", text);
        final$$Fields.put("sender", sender);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static MailEntry4Public createMailEntry(String subject,String text,AccountWrapper4Public sender,boolean delayed$Persistence,MailEntry4Public This) throws PersistenceException {
        PersistentMailEntry result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMailEntryFacade
                .newDelayedMailEntry(subject,text);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMailEntryFacade
                .newMailEntry(subject,text,-1);
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
            AbstractPersistentRoot sender = (AbstractPersistentRoot)this.getSender();
            if (sender != null) {
                result.put("sender", sender.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    sender.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && sender.hasEssentialFields())sender.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MailEntry provideCopy() throws PersistenceException{
        MailEntry result = this;
        result = new MailEntry(this.subject, 
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
    
    public MailEntry(String subject,String text,PersistentMail This,PersistentAccountWrapper sender,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)subject,(String)text,(PersistentMail)This,id);
        this.sender = sender;        
    }
    
    static public long getTypeId() {
        return 134;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 134) ConnectionHandler.getTheConnectionHandler().theMailEntryFacade
            .newMailEntry(subject,text,this.getId());
        super.store();
        if(this.getSender() != null){
            this.getSender().store();
            ConnectionHandler.getTheConnectionHandler().theMailEntryFacade.senderSet(this.getId(), getSender());
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
            ConnectionHandler.getTheConnectionHandler().theMailEntryFacade.senderSet(this.getId(), newValue);
        }
    }
    public PersistentMailEntry getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMailEntry result = (PersistentMailEntry)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentMailEntry)this.This;
    }
    
    public void accept(MailVisitor visitor) throws PersistenceException {
        visitor.handleMailEntry(this);
    }
    public <R> R accept(MailReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMailEntry(this);
    }
    public <E extends model.UserException>  void accept(MailExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMailEntry(this);
    }
    public <R, E extends model.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMailEntry(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMailEntry(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMailEntry(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMailEntry(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMailEntry(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSender() != null) return 1;
        if (this.getReceivers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMailEntry)This);
		if(this.isTheSameAs(This)){
			this.setSubject((String)final$$Fields.get("subject"));
			this.setText((String)final$$Fields.get("text"));
			this.setSender((PersistentAccountWrapper)final$$Fields.get("sender"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void answer() 
				throws PersistenceException{
        //TODO: implement method: answer
        
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
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
