
package model;

import persistence.*;

import java.math.BigInteger;

import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class T_1_7 extends model.GradesInThird implements PersistentT_1_7{
    
    private static T_1_74Public theT_1_7 = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static T_1_74Public getTheT_1_7() throws PersistenceException{
        if (theT_1_7 == null || reset$For$Test){
            if (reset$For$Test) theT_1_7 = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            T_1_74Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theT_1_7Facade.getTheT_1_7();
                            theT_1_7 = proxi;
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
                T_1_74Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theT_1_7== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theT_1_7;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theT_1_7;
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
    
    public T_1_7 provideCopy() throws PersistenceException{
        T_1_7 result = this;
        result = new T_1_7(this.subService, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public T_1_7(SubjInterface subService,PersistentGrade This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentGrade)This,id);        
    }
    
    static public long getTypeId() {
        return 224;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentT_1_7 getThis() throws PersistenceException {
        if(this.This == null){
            PersistentT_1_7 result = (PersistentT_1_7)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentT_1_7)this.This;
    }
    
    public void accept(GradesInThirdVisitor visitor) throws PersistenceException {
        visitor.handleT_1_7(this);
    }
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_1_7(this);
    }
    public <E extends model.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_1_7(this);
    }
    public <R, E extends model.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_1_7(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws PersistenceException {
        visitor.handleT_1_7(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_1_7(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_1_7(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_1_7(this);
    }
    public void accept(GradeVisitor visitor) throws PersistenceException {
        visitor.handleT_1_7(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_1_7(this);
    }
    public <E extends model.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_1_7(this);
    }
    public <R, E extends model.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_1_7(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleT_1_7(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_1_7(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_1_7(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_1_7(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleT_1_7(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_1_7(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_1_7(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_1_7(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentT_1_7)This);
		if(this.isTheSameAs(This)){
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
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
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
    	return new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(3));
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
