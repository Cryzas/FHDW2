
package model;

import persistence.*;


/* Additional import section end */

public abstract class Mail extends PersistentObject implements PersistentMail{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Mail4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMailFacade.getClass(objectId);
        return (Mail4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("receivers", this.getReceivers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            result.put("subject", this.getSubject());
            result.put("text", this.getText());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Mail provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Mail_ReceiversProxi receivers;
    protected String subject;
    protected String text;
    protected PersistentMail This;
    
    public Mail(String subject,String text,PersistentMail This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.receivers = new Mail_ReceiversProxi(this);
        this.subject = subject;
        this.text = text;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 123;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        this.getReceivers().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMailFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Mail_ReceiversProxi getReceivers() throws PersistenceException {
        return this.receivers;
    }
    public String getSubject() throws PersistenceException {
        return this.subject;
    }
    public void setSubject(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMailFacade.subjectSet(this.getId(), newValue);
        this.subject = newValue;
    }
    public String getText() throws PersistenceException {
        return this.text;
    }
    public void setText(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMailFacade.textSet(this.getId(), newValue);
        this.text = newValue;
    }
    protected void setThis(PersistentMail newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMail)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMailFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentMail getThis() throws PersistenceException ;
    
    
    
    public FolderSearchList getParentFolder() 
				throws PersistenceException{
        FolderSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theFolderFacade
										.inverseGetMails(getThis().getId(), getThis().getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMail)This);
		if(this.isTheSameAs(This)){
			this.setSubject((String)final$$Fields.get("subject"));
			this.setText((String)final$$Fields.get("text"));
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
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
