
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NoProgram extends model.ProgramStudent implements PersistentNoProgram{
    
    private static NoProgram4Public theNoProgram = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static NoProgram4Public getTheNoProgram() throws PersistenceException{
        if (theNoProgram == null || reset$For$Test){
            if (reset$For$Test) theNoProgram = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            NoProgram4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theNoProgramFacade.getTheNoProgram();
                            theNoProgram = proxi;
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
                NoProgram4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theNoProgram== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theNoProgram;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theNoProgram;
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
    
    public NoProgram provideCopy() throws PersistenceException{
        NoProgram result = this;
        result = new NoProgram(this.programCopy, 
                               this.This, 
                               this.getId());
        result.modules = this.modules.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NoProgram(PersistentProgramSGroup programCopy,PersistentProgramStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentProgramSGroup)programCopy,(PersistentProgramStudent)This,id);        
    }
    
    static public long getTypeId() {
        return 285;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentNoProgram getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNoProgram result = (PersistentNoProgram)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentNoProgram)this.This;
    }
    
    public void accept(ProgramStudentVisitor visitor) throws PersistenceException {
        visitor.handleNoProgram(this);
    }
    public <R> R accept(ProgramStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoProgram(this);
    }
    public <E extends model.UserException>  void accept(ProgramStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoProgram(this);
    }
    public <R, E extends model.UserException> R accept(ProgramStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoProgram(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoProgram(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoProgram(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoProgram(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleNoProgram(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoProgram(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoProgram(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoProgram(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNoProgram)This);
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
