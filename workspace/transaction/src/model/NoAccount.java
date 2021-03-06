
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NoAccount extends model.Account implements PersistentNoAccount{
    
    private static NoAccount4Public theNoAccount = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static NoAccount4Public getTheNoAccount() throws PersistenceException{
        if (theNoAccount == null || reset$For$Test){
            if (reset$For$Test) theNoAccount = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            NoAccount4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theNoAccountFacade.getTheNoAccount();
                            theNoAccount = proxi;
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
                NoAccount4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theNoAccount== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theNoAccount;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theNoAccount;
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
    
    public NoAccount provideCopy() throws PersistenceException{
        NoAccount result = this;
        result = new NoAccount(this.subService, 
                               this.This, 
                               this.name, 
                               this.balance, 
                               this.getId());
        result.entries = this.entries.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NoAccount(SubjInterface subService,PersistentAccountHandle This,String name,common.Fraction balance,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentAccountHandle)This,(String)name,(common.Fraction)balance,id);        
    }
    
    static public long getTypeId() {
        return 140;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentNoAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNoAccount result = (PersistentNoAccount)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentNoAccount)this.This;
    }
    
    public void accept(AccountVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AccountReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(AccountExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(AccountReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEntries().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNoAccount)This);
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
        getThis().setName(serverConstants.ToStringConstants.NoAccountName);
        getThis().delete$Me();
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
