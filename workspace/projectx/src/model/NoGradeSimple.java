
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NoGradeSimple extends model.GradesInSimple implements PersistentNoGradeSimple{
    
    private static NoGradeSimple4Public theNoGradeSimple = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static NoGradeSimple4Public getTheNoGradeSimple() throws PersistenceException{
        if (theNoGradeSimple == null || reset$For$Test){
            if (reset$For$Test) theNoGradeSimple = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            NoGradeSimple4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theNoGradeSimpleFacade.getTheNoGradeSimple();
                            theNoGradeSimple = proxi;
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
                NoGradeSimple4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theNoGradeSimple== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theNoGradeSimple;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theNoGradeSimple;
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
    
    public NoGradeSimple provideCopy() throws PersistenceException{
        NoGradeSimple result = this;
        result = new NoGradeSimple(this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NoGradeSimple(PersistentGradesInSimpleOrThird This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentGradesInSimpleOrThird)This,id);        
    }
    
    static public long getTypeId() {
        return 218;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentNoGradeSimple getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNoGradeSimple result = (PersistentNoGradeSimple)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentNoGradeSimple)this.This;
    }
    
    public void accept(GradesInSimpleVisitor visitor) throws PersistenceException {
        visitor.handleNoGradeSimple(this);
    }
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoGradeSimple(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoGradeSimple(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoGradeSimple(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws PersistenceException {
        visitor.handleNoGradeSimple(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoGradeSimple(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoGradeSimple(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoGradeSimple(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoGradeSimple(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoGradeSimple(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoGradeSimple(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoGradeSimple(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNoGradeSimple)This);
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
