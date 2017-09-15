
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class BFalse extends model.MyBoolean implements PersistentBFalse{
    
    private static BFalse4Public theBFalse = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static BFalse4Public getTheBFalse() throws PersistenceException{
        if (theBFalse == null || reset$For$Test){
            if (reset$For$Test) theBFalse = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            BFalse4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theBFalseFacade.getTheBFalse();
                            theBFalse = proxi;
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
                BFalse4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theBFalse== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theBFalse;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theBFalse;
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
    
    public BFalse provideCopy() throws PersistenceException{
        BFalse result = this;
        result = new BFalse(this.This, 
                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public BFalse(PersistentMyBoolean This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMyBoolean)This,id);        
    }
    
    static public long getTypeId() {
        return 282;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentBFalse getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBFalse result = (PersistentBFalse)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentBFalse)this.This;
    }
    
    public void accept(MyBooleanVisitor visitor) throws PersistenceException {
        visitor.handleBFalse(this);
    }
    public <R> R accept(MyBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBFalse(this);
    }
    public <E extends model.UserException>  void accept(MyBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBFalse(this);
    }
    public <R, E extends model.UserException> R accept(MyBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBFalse(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBFalse(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBFalse(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBFalse(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBFalse(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBFalse)This);
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
