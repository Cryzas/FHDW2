
package model;

import persistence.*;
import common.Fraction;
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
        result = new ProgramManager(this.subService, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ProgramManager_ProgramsProxi programs;
    protected SubjInterface subService;
    protected PersistentProgramManager This;
    
    public ProgramManager(SubjInterface subService,PersistentProgramManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.programs = new ProgramManager_ProgramsProxi(this);
        this.subService = subService;
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
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ProgramManager_ProgramsProxi getPrograms() throws PersistenceException {
        return this.programs;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade.subServiceSet(this.getId(), newValue);
        }
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProgramManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
        this.setThis((PersistentProgramManager)This);
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
    public void startStudyGroup(final Program4Public program, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		StartStudyGroupCommand4Public command = model.meta.StartStudyGroupCommand.createStartStudyGroupCommand(name, nw, d1170);
		command.setProgram(program);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
			throw new AlreadyExistsInParentException(String.format(ProgramAlreadyExistsInDBMessage, name));
		}
    	if (ModuleAbstract.getModuleAbstractByName(name).iterator().hasNext()) {
			throw new AlreadyExistsInParentException(String.format(ModuleAlreadyExistsInDBMessage, name));
		}
    	getThis().getPrograms().add(Program.createProgram(name));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    	
    }
    public void startStudyGroup(final Program4Public program, final String name) 
				throws model.AlreadyExistsInParentException, model.NoFractionValueException, PersistenceException{
    	if(StudyGroup.getStudyGroupByName(name).iterator().hasNext()) {
    		throw new AlreadyExistsInParentException(String.format(GroupAlreadyExistsMessage, name));
    	}
    	program.getModules().applyToAllException(module -> {
    		module.accept(new ModuleAbstractExceptionVisitor<NoFractionValueException>() {

				@Override
				public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar)
						throws PersistenceException, NoFractionValueException {
		    		if(moduleAtomar.getCreditPoints().lessOrEquals(Fraction.Null)) {
		    			throw new NoFractionValueException(String.format(NoCPMessage, moduleAtomar.getName()));
		    		}
				}

				@Override
				public void handleModuleGroup(ModuleGroup4Public moduleGroup)
						throws PersistenceException, NoFractionValueException {
					moduleGroup.getModules().applyToAllException(module2 -> {
						module2.accept(this);
					});
				}

				@Override
				public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits)
						throws PersistenceException, NoFractionValueException {
					moduleWithUnits.getUnits().applyToAllException(unit -> {
						if(unit.getCreditPoints().lessOrEquals(Fraction.Null)) {
			    			throw new NoFractionValueException(String.format(NoCPMessage, moduleWithUnits.getName()));
			    		}
					});
				}
			});
    	});
    	StudyGroup4Public toBeAdded = StudyGroup.createStudyGroup(name);
    	toBeAdded.setProgram(program.copyForStudyGroup());
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    static String ProgramAlreadyExistsInDBMessage = "Es existiert bereits ein Programm mit dem Namen %s.";
    static String ModuleAlreadyExistsInDBMessage = "Es existiert bereits ein Modul mit dem Namen %s.";
    static String GroupAlreadyExistsMessage = "Es existiert bereits eine Studiengruppe mit dem Namen %s.";
    static String NoCPMessage = "Das Modul %s enthält keine Credit-Points.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
