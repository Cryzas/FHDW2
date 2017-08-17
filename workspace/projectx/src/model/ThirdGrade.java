
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ThirdGrade extends model.GradeSystem implements PersistentThirdGrade{
    
    private static ThirdGrade4Public theThirdGrade = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static ThirdGrade4Public getTheThirdGrade() throws PersistenceException{
        if (theThirdGrade == null || reset$For$Test){
            if (reset$For$Test) theThirdGrade = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            ThirdGrade4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theThirdGradeFacade.getTheThirdGrade();
                            theThirdGrade = proxi;
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
                ThirdGrade4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theThirdGrade== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theThirdGrade;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theThirdGrade;
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
    
    public ThirdGrade provideCopy() throws PersistenceException{
        ThirdGrade result = this;
        result = new ThirdGrade(this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public ThirdGrade(PersistentGradeSystem This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentGradeSystem)This,id);        
    }
    
    static public long getTypeId() {
        return 208;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentThirdGrade getThis() throws PersistenceException {
        if(this.This == null){
            PersistentThirdGrade result = (PersistentThirdGrade)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentThirdGrade)this.This;
    }
    
    public void accept(GradeSystemVisitor visitor) throws PersistenceException {
        visitor.handleThirdGrade(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdGrade(this);
    }
    public <E extends model.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdGrade(this);
    }
    public <R, E extends model.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdGrade(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleThirdGrade(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdGrade(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdGrade(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdGrade(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentThirdGrade)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
