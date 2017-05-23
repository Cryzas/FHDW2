
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Account extends model.abstractAcc implements PersistentAccount{
    
    
    public static Account4Public createAccount(String name) throws PersistenceException{
        return createAccount(name,false);
    }
    
    public static Account4Public createAccount(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Account4Public createAccount(String name,boolean delayed$Persistence,Account4Public This) throws PersistenceException {
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot InBox = (AbstractPersistentRoot)this.getInBox();
            if (InBox != null) {
                result.put("InBox", InBox.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    InBox.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && InBox.hasEssentialFields())InBox.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot OutBox = (AbstractPersistentRoot)this.getOutBox();
            if (OutBox != null) {
                result.put("OutBox", OutBox.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    OutBox.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && OutBox.hasEssentialFields())OutBox.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot drafts = (AbstractPersistentRoot)this.getDrafts();
            if (drafts != null) {
                result.put("drafts", drafts.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    drafts.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && drafts.hasEssentialFields())drafts.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("folders", this.getFolders().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Account provideCopy() throws PersistenceException{
        Account result = this;
        result = new Account(this.name, 
                             this.This, 
                             this.InBox, 
                             this.OutBox, 
                             this.drafts, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentFolder InBox;
    protected PersistentFolder OutBox;
    protected PersistentFolder drafts;
    protected Account_FoldersProxi folders;
    
    public Account(String name,PersistentabstractAcc This,PersistentFolder InBox,PersistentFolder OutBox,PersistentFolder drafts,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentabstractAcc)This,id);
        this.InBox = InBox;
        this.OutBox = OutBox;
        this.drafts = drafts;
        this.folders = new Account_FoldersProxi(this);        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 119) ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .newAccount(name,this.getId());
        super.store();
        if(this.getInBox() != null){
            this.getInBox().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.InBoxSet(this.getId(), getInBox());
        }
        if(this.getOutBox() != null){
            this.getOutBox().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.OutBoxSet(this.getId(), getOutBox());
        }
        if(this.getDrafts() != null){
            this.getDrafts().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.draftsSet(this.getId(), getDrafts());
        }
        this.getFolders().store();
        
    }
    
    public Folder4Public getInBox() throws PersistenceException {
        return this.InBox;
    }
    public void setInBox(Folder4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.InBox)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.InBox = (PersistentFolder)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.InBoxSet(this.getId(), newValue);
        }
    }
    public Folder4Public getOutBox() throws PersistenceException {
        return this.OutBox;
    }
    public void setOutBox(Folder4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.OutBox)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.OutBox = (PersistentFolder)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.OutBoxSet(this.getId(), newValue);
        }
    }
    public Folder4Public getDrafts() throws PersistenceException {
        return this.drafts;
    }
    public void setDrafts(Folder4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.drafts)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.drafts = (PersistentFolder)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.draftsSet(this.getId(), newValue);
        }
    }
    public Account_FoldersProxi getFolders() throws PersistenceException {
        return this.folders;
    }
    public PersistentAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccount result = (PersistentAccount)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccount)this.This;
    }
    
    public void accept(abstractAccVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getInBox() != null) return 1;
        if (this.getOutBox() != null) return 1;
        if (this.getDrafts() != null) return 1;
        if (this.getFolders().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccount)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setInBox(Folder.createFolder("InBox"));
    	getThis().setOutBox(Folder.createFolder("OutBox"));
    	getThis().setDrafts(Folder.createFolder("Drafts"));
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public AccountWrapper4Public wrap() 
				throws PersistenceException{
        return AccountWrapper.createAccountWrapper(getThis().getName(), getThis());
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void createDraft(final String subject, final String text) 
				throws PersistenceException{
    	getThis().getDrafts().addMail(Draft.createDraft(subject, text, getThis().wrap()));
	}
    public void createFolder(final String name) 
				throws PersistenceException{
    	getThis().getFolders().add(Folder.createFolder(name));
		
	}
    public void receive(final MailEntry4Public mail) 
				throws PersistenceException{
    	getThis().getInBox().addMail(mail);
	}
    public void send(final Draft4Public draft) 
				throws PersistenceException{
		getThis().getOutBox().addMail(draft.send());
		getThis().getDrafts().getMails().removeFirst(draft);
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
