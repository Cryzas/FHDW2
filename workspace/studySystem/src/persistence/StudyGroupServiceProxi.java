package persistence;



import model.visitor.*;

public class StudyGroupServiceProxi extends subAdminServiceProxi implements PersistentStudyGroupService{
    
    public StudyGroupServiceProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -302;
    }
    
    public void setGroupManager(StudyGroupServiceGroupManager4Public newValue) throws PersistenceException {
        ((PersistentStudyGroupService)this.getTheObject()).setGroupManager(newValue);
    }
    public PersistentStudyGroupService getThis() throws PersistenceException {
        return ((PersistentStudyGroupService)this.getTheObject()).getThis();
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    
    
    public UnitSGroupSearchList ToUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).ToUnit_Path_In_SwapCPonModuleWithUnits(module);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).deregister(observee);
    }
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).fromUnit_Path_In_SwapCPonModuleWithUnits(module);
    }
    public StudyGroupManager4Public getGroupManager() 
				throws PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).getGroupManager();
    }
    public StudyGroupSearchList groups_Path_In_DeleteStudyGroups(final StudyGroupManager4Public manager) 
				throws model.UserException, PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).groups_Path_In_DeleteStudyGroups(manager);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).register(observee);
    }
    public void setGroupManager(final StudyGroupManager4Public groupManager) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).setGroupManager(groupManager);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).signalChanged(signal);
    }
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).students_Path_In_AddStudentToGroup();
    }
    public StudentSearchList students_Path_In_RemoveStudentFromGroup(final StudyGroup4Public group) 
				throws model.UserException, PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).students_Path_In_RemoveStudentFromGroup(group);
    }
    public String studyGroupService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).studyGroupService_Menu_Filter(anything);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).updateObservers(event);
    }
    public void updatePLZ() 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).updatePLZ();
    }
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).addStudentToGroup(group, students);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).createStudent(group, firstName, lastName, birthDate);
    }
    public void deleteStudyGroups(final StudyGroupManager4Public manager, final StudyGroupSearchList groups) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).deleteStudyGroups(manager, groups);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).disconnected();
    }
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).endStudyGroup(studyGroup);
    }
    public StudentSearchList getStudents() 
				throws PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).getStudents();
    }
    public void groupManager_update(final model.meta.StudyGroupManagerMssgs event) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).groupManager_update(event);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentStudyGroupService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).removeError(error);
    }
    public void removeStudentFromGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).removeStudentFromGroup(group, students);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
    }
    public void updateMe() 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).updateMe();
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
        ((PersistentStudyGroupService)this.getTheObject()).updatePLZImplementation();
    }

    
}
