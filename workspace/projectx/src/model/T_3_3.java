
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class T_3_3 extends model.GradesInThird implements PersistentT_3_3{
    
    private static T_3_34Public theT_3_3 = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static T_3_34Public getTheT_3_3() throws PersistenceException{
        if (theT_3_3 == null || reset$For$Test){
            if (reset$For$Test) theT_3_3 = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            T_3_34Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theT_3_3Facade.getTheT_3_3();
                            theT_3_3 = proxi;
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
                T_3_34Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theT_3_3== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theT_3_3;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theT_3_3;
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
    
    public T_3_3 provideCopy() throws PersistenceException{
        T_3_3 result = this;
        result = new T_3_3(this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public T_3_3(PersistentGradesInSimpleOrThird This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentGradesInSimpleOrThird)This,id);        
    }
    
    static public long getTypeId() {
        return 263;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentT_3_3 getThis() throws PersistenceException {
        if(this.This == null){
            PersistentT_3_3 result = (PersistentT_3_3)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentT_3_3)this.This;
    }
    
    public void accept(GradesInThirdVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentT_3_3)This);
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
