
package model;

import persistence.*;
import model.meta.StringFACTORY;
import model.visitor.*;


/* Additional import section end */

public class StudentManager extends PersistentObject implements PersistentStudentManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static StudentManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade.getClass(objectId);
        return (StudentManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static StudentManager4Public createStudentManager() throws PersistenceException{
        return createStudentManager(false);
    }
    
    public static StudentManager4Public createStudentManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentStudentManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade
                .newDelayedStudentManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade
                .newStudentManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudentManager4Public createStudentManager(boolean delayed$Persistence,StudentManager4Public This) throws PersistenceException {
        PersistentStudentManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade
                .newDelayedStudentManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade
                .newStudentManager(-1);
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
            result.put("students", this.getStudents().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public StudentManager provideCopy() throws PersistenceException{
        StudentManager result = this;
        result = new StudentManager(this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected StudentManager_StudentsProxi students;
    protected PersistentStudentManager This;
    
    public StudentManager(PersistentStudentManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.students = new StudentManager_StudentsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 201;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 201) ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade
            .newStudentManager(this.getId());
        super.store();
        this.getStudents().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public StudentManager_StudentsProxi getStudents() throws PersistenceException {
        return this.students;
    }
    protected void setThis(PersistentStudentManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudentManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudentManager result = (PersistentStudentManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudentManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getStudents().getLength() > 0) return 1;
        return 0;
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
    public void changeGradeOfModuleSimple(final ModuleAtomarStudent4Public module, final String grade, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeGradeOfModuleSimpleCommand4Public command = model.meta.ChangeGradeOfModuleSimpleCommand.createChangeGradeOfModuleSimpleCommand(grade, nw, d1170);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeGradeOfModuleThird(final ModuleAtomarStudent4Public module, final String grade, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeGradeOfModuleThirdCommand4Public command = model.meta.ChangeGradeOfModuleThirdCommand.createChangeGradeOfModuleThirdCommand(grade, nw, d1170);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeGradeOfUnitCommand4Public command = model.meta.ChangeGradeOfUnitCommand.createChangeGradeOfUnitCommand(grade, nw, d1170);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createStudent(final String firstName, final String lastName, final java.sql.Date birthDate, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateStudentCommand4Public command = model.meta.CreateStudentCommand.createCreateStudentCommand(firstName, lastName, birthDate, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudentManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student) 
				throws model.UserException, PersistenceException{
    	student.setProgram(group.getProgram().copyForStudent());
    	group.getStudents().add(student);
    }
    public void changeGradeOfModuleSimple(final ModuleAtomarStudent4Public module, final String grade) 
				throws PersistenceException{
    	GradesInSimple4Public newGrade = StringFACTORY.createObjectBySubTypeNameForGradesInSimple(grade);
    	module.changeGrade(newGrade);
    }
    public void changeGradeOfModuleThird(final ModuleAtomarStudent4Public module, final String grade) 
				throws PersistenceException{
    	GradesInThird4Public newGrade = StringFACTORY.createObjectBySubTypeNameForGradesInThird(grade);
    	module.changeGrade(newGrade);
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade) 
				throws PersistenceException{
    	GradesInThird4Public newGrade = StringFACTORY.createObjectBySubTypeNameForGradesInThird(grade);
    	unit.changeGrade(newGrade);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createStudent(final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
        getThis().getStudents().add(Student.createStudent(firstName, lastName, birthDate));        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
