
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudyGroupManager extends PersistentObject implements PersistentStudyGroupManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static StudyGroupManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.getClass(objectId);
        return (StudyGroupManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static StudyGroupManager4Public createStudyGroupManager() throws PersistenceException{
        return createStudyGroupManager(false);
    }
    
    public static StudyGroupManager4Public createStudyGroupManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentStudyGroupManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newDelayedStudyGroupManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newStudyGroupManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudyGroupManager4Public createStudyGroupManager(boolean delayed$Persistence,StudyGroupManager4Public This) throws PersistenceException {
        PersistentStudyGroupManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newDelayedStudyGroupManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newStudyGroupManager(-1);
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
            result.put("groups", this.getGroups().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public StudyGroupManager provideCopy() throws PersistenceException{
        StudyGroupManager result = this;
        result = new StudyGroupManager(this.subService, 
                                       this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected StudyGroupManager_GroupsProxi groups;
    protected SubjInterface subService;
    protected PersistentStudyGroupManager This;
    
    public StudyGroupManager(SubjInterface subService,PersistentStudyGroupManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.groups = new StudyGroupManager_GroupsProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 186;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 186) ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
            .newStudyGroupManager(this.getId());
        super.store();
        this.getGroups().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public StudyGroupManager_GroupsProxi getGroups() throws PersistenceException {
        return this.groups;
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
            ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentStudyGroupManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudyGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudyGroupManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyGroupManager result = (PersistentStudyGroupManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyGroupManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getGroups().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        model.meta.StudyGroupManagerAddStudentToGroupStudyGroupStudentMssg event = new model.meta.StudyGroupManagerAddStudentToGroupStudyGroupStudentMssg(group, student, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddStudentToGroupCommand4Public command = model.meta.AddStudentToGroupCommand.createAddStudentToGroupCommand(nw, d1170);
		command.setGroup(group);
		command.setStudent(student);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        model.meta.StudyGroupManagerCreateStudentStudyGroupStringStringDateMssg event = new model.meta.StudyGroupManagerCreateStudentStudyGroupStringStringDateMssg(group, firstName, lastName, birthDate, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateStudentCommand4Public command = model.meta.CreateStudentCommand.createCreateStudentCommand(firstName, lastName, birthDate, nw, d1170);
		command.setGroup(group);
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
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyFinishedException, PersistenceException{
        model.meta.StudyGroupManagerEndStudyGroupStudyGroupMssg event = new model.meta.StudyGroupManagerEndStudyGroupStudyGroupMssg(studyGroup, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void endStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		EndStudyGroupCommand4Public command = model.meta.EndStudyGroupCommand.createEndStudyGroupCommand(nw, d1170);
		command.setStudyGroup(studyGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudyGroupManager)This);
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
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.AlreadyFinishedException, model.UnitSwapException, PersistenceException{
        model.meta.StudyGroupManagerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssg event = new model.meta.StudyGroupManagerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssg(module, fromUnit, ToUnit, creditPoints, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		SwapCPonModuleWithUnitsCommand4Public command = model.meta.SwapCPonModuleWithUnitsCommand.createSwapCPonModuleWithUnitsCommand(creditPoints, nw, d1170);
		command.setModule(module);
		command.setFromUnit(fromUnit);
		command.setToUnit(ToUnit);
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
    
    public void addStudentToGroupImplementation(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
       group.addStudent(student);
       student.setProgram(group.getProgram().copyForStudent());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createStudentImplementation(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
    	Student4Public newStudent = Student.createStudent(firstName, lastName, birthDate);
    	getThis().addStudentToGroup(group, newStudent);
    }
    public void endStudyGroupImplementation(final StudyGroup4Public studyGroup) 
				throws model.AlreadyFinishedException, PersistenceException{
        studyGroup.endStudyGroup();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    	
    }
    public void swapCPonModuleWithUnitsImplementation(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.AlreadyFinishedException, model.UnitSwapException, PersistenceException{
    	module.swapCP(fromUnit, ToUnit, creditPoints);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
