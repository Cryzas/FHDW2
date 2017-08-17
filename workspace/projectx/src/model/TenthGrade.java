
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class TenthGrade extends model.GradeSystem implements PersistentTenthGrade{
    
    private static TenthGrade4Public theTenthGrade = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static TenthGrade4Public getTheTenthGrade() throws PersistenceException{
        if (theTenthGrade == null || reset$For$Test){
            if (reset$For$Test) theTenthGrade = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            TenthGrade4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theTenthGradeFacade.getTheTenthGrade();
                            theTenthGrade = proxi;
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
                TenthGrade4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theTenthGrade== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theTenthGrade;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theTenthGrade;
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
    
    public TenthGrade provideCopy() throws PersistenceException{
        TenthGrade result = this;
        result = new TenthGrade(this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public TenthGrade(PersistentGradeSystem This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentGradeSystem)This,id);        
    }
    
    static public long getTypeId() {
        return 210;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentTenthGrade getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTenthGrade result = (PersistentTenthGrade)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTenthGrade)this.This;
    }
    
    public void accept(GradeSystemVisitor visitor) throws PersistenceException {
        visitor.handleTenthGrade(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTenthGrade(this);
    }
    public <E extends model.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTenthGrade(this);
    }
    public <R, E extends model.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTenthGrade(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTenthGrade(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTenthGrade(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTenthGrade(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTenthGrade(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTenthGrade)This);
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
