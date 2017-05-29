
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class FilledCBState extends model.ClipBoardState implements PersistentFilledCBState{
    
    
    public static FilledCBState4Public createFilledCBState(Containee4Public contents) throws PersistenceException{
        return createFilledCBState(contents,false);
    }
    
    public static FilledCBState4Public createFilledCBState(Containee4Public contents,boolean delayed$Persistence) throws PersistenceException {
        PersistentFilledCBState result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade
                .newDelayedFilledCBState();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade
                .newFilledCBState(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("contents", contents);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static FilledCBState4Public createFilledCBState(Containee4Public contents,boolean delayed$Persistence,FilledCBState4Public This) throws PersistenceException {
        PersistentFilledCBState result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade
                .newDelayedFilledCBState();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade
                .newFilledCBState(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("contents", contents);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot contents = (AbstractPersistentRoot)this.getContents();
            if (contents != null) {
                result.put("contents", contents.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    contents.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && contents.hasEssentialFields())contents.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public FilledCBState provideCopy() throws PersistenceException{
        FilledCBState result = this;
        result = new FilledCBState(this.This, 
                                   this.contents, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentContainee contents;
    
    public FilledCBState(PersistentClipBoardState This,PersistentContainee contents,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentClipBoardState)This,id);
        this.contents = contents;        
    }
    
    static public long getTypeId() {
        return 128;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 128) ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade
            .newFilledCBState(this.getId());
        super.store();
        if(this.getContents() != null){
            this.getContents().store();
            ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade.contentsSet(this.getId(), getContents());
        }
        
    }
    
    public Containee4Public getContents() throws PersistenceException {
        return this.contents;
    }
    public void setContents(Containee4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.contents)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.contents = (PersistentContainee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade.contentsSet(this.getId(), newValue);
        }
    }
    public PersistentFilledCBState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFilledCBState result = (PersistentFilledCBState)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentFilledCBState)this.This;
    }
    
    public void accept(ClipBoardStateVisitor visitor) throws PersistenceException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends model.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends model.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFilledCBState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFilledCBState(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getContents() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFilledCBState)This);
		if(this.isTheSameAs(This)){
			this.setContents((PersistentContainee)final$$Fields.get("contents"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
