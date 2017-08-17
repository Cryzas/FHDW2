
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ProgramManager extends PersistentObject implements PersistentProgramManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ProgramManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.getClass(objectId);
        return (ProgramManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ProgramManager4Public createProgramManager() throws PersistenceException{
        return createProgramManager(false);
    }
    
    public static ProgramManager4Public createProgramManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentProgramManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
                .newDelayedProgramManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
                .newProgramManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ProgramManager4Public createProgramManager(boolean delayed$Persistence,ProgramManager4Public This) throws PersistenceException {
        PersistentProgramManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
                .newDelayedProgramManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
                .newProgramManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
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
            result.put("programs", this.getPrograms().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ProgramManager provideCopy() throws PersistenceException{
        ProgramManager result = this;
        result = new ProgramManager(this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ProgramManager_ProgramsProxi programs;
    protected PersistentProgramManager This;
    
    public ProgramManager(PersistentProgramManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.programs = new ProgramManager_ProgramsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 148;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 148) ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
            .newProgramManager(this.getId());
        super.store();
        this.getPrograms().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ProgramManager_ProgramsProxi getPrograms() throws PersistenceException {
        return this.programs;
    }
    protected void setThis(PersistentProgramManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProgramManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentProgramManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgramManager result = (PersistentProgramManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgramManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getPrograms().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addModuleToProg(final Program4Public program, final ModuleAbstract4Public module, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddModuleToProgCommand4Public command = model.meta.AddModuleToProgCommand.createAddModuleToProgCommand(nw, d1170);
		command.setProgram(program);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createProgram(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateProgramCommand4Public command = model.meta.CreateProgramCommand.createCreateProgramCommand(name, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProgramManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModuleToProg(final Program4Public program, final ModuleAbstract4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
    	program.addModule(module);        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createProgram(final String name) 
				throws model.AlreadyExistsInParentException, PersistenceException{
    	if (Program.getProgramByName(name).iterator().hasNext()) {
			throw new AlreadyExistsInParentException(ProgramAlreadyExistsInDBMessage);
		}
    	if (ModuleAbstract.getModuleAbstractByName(name).iterator().hasNext()) {
			throw new AlreadyExistsInParentException(ModuleAlreadyExistsInDBMessage);
		}
    	getThis().getPrograms().add(Program.createProgram(name));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String ProgramAlreadyExistsInDBMessage = "Es existiert bereits ein Programm mit eingegebenem Namen.";
    static String ModuleAlreadyExistsInDBMessage = "Es existiert bereits ein Modul mit eingegebenem Namen.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
