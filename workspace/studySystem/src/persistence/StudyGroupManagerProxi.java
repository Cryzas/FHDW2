package persistence;



import model.visitor.*;

public class StudyGroupManagerProxi extends PersistentProxi implements PersistentStudyGroupManager{
    
    public StudyGroupManagerProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 186;
    }
    
    public StudyGroupManager_GroupsProxi getGroups() throws PersistenceException {
        return ((PersistentStudyGroupManager)this.getTheObject()).getGroups();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentStudyGroupManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentStudyGroupManager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentStudyGroupManager getThis() throws PersistenceException {
        return ((PersistentStudyGroupManager)this.getTheObject()).getThis();
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
    
    
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).addStudentToGroup(group, student);
    }
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).addStudentToGroup(group, student, invoker);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).createStudent(group, firstName, lastName, birthDate);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).createStudent(group, firstName, lastName, birthDate, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).deregister(observee);
    }
    public void endStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).endStudyGroup(studyGroup, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).register(observee);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints, invoker);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).updateObservers(event);
    }
    public void addStudentToGroupImplementation(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).addStudentToGroupImplementation(group, student);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createStudentImplementation(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).createStudentImplementation(group, firstName, lastName, birthDate);
    }
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyFinishedException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).endStudyGroup(studyGroup);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.AlreadyFinishedException, model.UnitSwapException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
    }

    
}
