
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ClipBoard extends PersistentObject implements PersistentClipBoard{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ClipBoard4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theClipBoardFacade.getClass(objectId);
        return (ClipBoard4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ClipBoard4Public createClipBoard() throws PersistenceException{
        return createClipBoard(false);
    }
    
    public static ClipBoard4Public createClipBoard(boolean delayed$Persistence) throws PersistenceException {
        PersistentClipBoard result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theClipBoardFacade
                .newDelayedClipBoard();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theClipBoardFacade
                .newClipBoard(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ClipBoard4Public createClipBoard(boolean delayed$Persistence,ClipBoard4Public This) throws PersistenceException {
        PersistentClipBoard result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theClipBoardFacade
                .newDelayedClipBoard();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theClipBoardFacade
                .newClipBoard(-1);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ClipBoard provideCopy() throws PersistenceException{
        ClipBoard result = this;
        result = new ClipBoard(this.state, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentClipBoardState state;
    protected PersistentClipBoard This;
    
    public ClipBoard(PersistentClipBoardState state,PersistentClipBoard This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.state = state;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 130) ConnectionHandler.getTheConnectionHandler().theClipBoardFacade
            .newClipBoard(this.getId());
        super.store();
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theClipBoardFacade.stateSet(this.getId(), getState());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theClipBoardFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ClipBoardState4Public getState() throws PersistenceException {
        return this.state;
    }
    public void setState(ClipBoardState4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentClipBoardState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theClipBoardFacade.stateSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentClipBoard newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentClipBoard)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theClipBoardFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentClipBoard getThis() throws PersistenceException {
        if(this.This == null){
            PersistentClipBoard result = (PersistentClipBoard)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentClipBoard)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleClipBoard(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleClipBoard(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleClipBoard(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleClipBoard(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentClipBoard)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void copy(final Containee4Public containee) 
				throws PersistenceException{
    	getThis().setState(FilledCBState.createFilledCBState(containee));
    }
    public void deleteClipped() 
				throws PersistenceException{
    	getThis().setState(EmptyCBState.getTheEmptyCBState());        
    }
    public Containee4Public fetchClipped() 
				throws model.FileSystemException, PersistenceException{
        return getThis().getState().accept(new ClipBoardStateReturnExceptionVisitor<Containee4Public, FileSystemException>() {

			@Override
			public Containee4Public handleEmptyCBState(EmptyCBState4Public emptyCBState)
					throws PersistenceException, FileSystemException {
				throw new FileSystemException("Nichts kopiert!!!!!!!!!!!");
			}

			@Override
			public Containee4Public handleFilledCBState(FilledCBState4Public filledCBState)
					throws PersistenceException, FileSystemException {
				return filledCBState.getContents();
			}
		});
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setState(EmptyCBState.getTheEmptyCBState());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
