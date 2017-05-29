
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class EmptyCBState extends model.ClipBoardState implements PersistentEmptyCBState{
    
    private static EmptyCBState4Public theEmptyCBState = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static EmptyCBState4Public getTheEmptyCBState() throws PersistenceException{
        if (theEmptyCBState == null || reset$For$Test){
            if (reset$For$Test) theEmptyCBState = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            EmptyCBState4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theEmptyCBStateFacade.getTheEmptyCBState();
                            theEmptyCBState = proxi;
                            if(proxi.getId() < 0) {
                                ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                                proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                                proxi.initializeOnCreation();
                            }
                        } catch (PersistenceException e){
                            exception = e;
                        } finally {
                            $$lock.notify();
                        }
                        
                    }
                }
                EmptyCBState4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theEmptyCBState== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theEmptyCBState;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theEmptyCBState;
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
    
    public EmptyCBState provideCopy() throws PersistenceException{
        EmptyCBState result = this;
        result = new EmptyCBState(this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public EmptyCBState(PersistentClipBoardState This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentClipBoardState)This,id);        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentEmptyCBState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentEmptyCBState result = (PersistentEmptyCBState)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentEmptyCBState)this.This;
    }
    
    public void accept(ClipBoardStateVisitor visitor) throws PersistenceException {
        visitor.handleEmptyCBState(this);
    }
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEmptyCBState(this);
    }
    public <E extends model.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEmptyCBState(this);
    }
    public <R, E extends model.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEmptyCBState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEmptyCBState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEmptyCBState(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEmptyCBState(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEmptyCBState(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEmptyCBState)This);
		if(this.isTheSameAs(This)){
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
