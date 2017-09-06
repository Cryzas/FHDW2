
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class SimpleGradeSystem extends model.GradeSystem implements PersistentSimpleGradeSystem{
    
    private static SimpleGradeSystem4Public theSimpleGradeSystem = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static SimpleGradeSystem4Public getTheSimpleGradeSystem() throws PersistenceException{
        if (theSimpleGradeSystem == null || reset$For$Test){
            if (reset$For$Test) theSimpleGradeSystem = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            SimpleGradeSystem4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theSimpleGradeSystemFacade.getTheSimpleGradeSystem();
                            theSimpleGradeSystem = proxi;
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
                SimpleGradeSystem4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theSimpleGradeSystem== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theSimpleGradeSystem;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theSimpleGradeSystem;
    }
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public SimpleGradeSystem provideCopy() throws PersistenceException{
        SimpleGradeSystem result = this;
        result = new SimpleGradeSystem(this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public SimpleGradeSystem(PersistentGradeSystem This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentGradeSystem)This,id);        
    }
    
    static public long getTypeId() {
        return 213;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentSimpleGradeSystem getThis() throws PersistenceException {
        if(this.This == null){
            PersistentSimpleGradeSystem result = (PersistentSimpleGradeSystem)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentSimpleGradeSystem)this.This;
    }
    
    public void accept(GradeSystemVisitor visitor) throws PersistenceException {
        visitor.handleSimpleGradeSystem(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSimpleGradeSystem(this);
    }
    public <E extends model.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSimpleGradeSystem(this);
    }
    public <R, E extends model.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSimpleGradeSystem(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSimpleGradeSystem(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSimpleGradeSystem(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSimpleGradeSystem(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSimpleGradeSystem(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentSimpleGradeSystem)This);
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
