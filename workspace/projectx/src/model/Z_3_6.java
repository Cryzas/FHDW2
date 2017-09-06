
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Z_3_6 extends model.GradesInTenth implements PersistentZ_3_6{
    
    private static Z_3_64Public theZ_3_6 = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static Z_3_64Public getTheZ_3_6() throws PersistenceException{
        if (theZ_3_6 == null || reset$For$Test){
            if (reset$For$Test) theZ_3_6 = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            Z_3_64Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theZ_3_6Facade.getTheZ_3_6();
                            theZ_3_6 = proxi;
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
                Z_3_64Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theZ_3_6== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theZ_3_6;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theZ_3_6;
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
    
    public Z_3_6 provideCopy() throws PersistenceException{
        Z_3_6 result = this;
        result = new Z_3_6(this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Z_3_6(PersistentGradesInTenth This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentGradesInTenth)This,id);        
    }
    
    static public long getTypeId() {
        return 254;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentZ_3_6 getThis() throws PersistenceException {
        if(this.This == null){
            PersistentZ_3_6 result = (PersistentZ_3_6)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentZ_3_6)this.This;
    }
    
    public void accept(GradesInTenthVisitor visitor) throws PersistenceException {
        visitor.handleZ_3_6(this);
    }
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_3_6(this);
    }
    public <E extends model.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_3_6(this);
    }
    public <R, E extends model.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_3_6(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleZ_3_6(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_3_6(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_3_6(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_3_6(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentZ_3_6)This);
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
