package persistence;



import model.visitor.*;

public class StudentManageServiceICProxi extends subAdminServiceICProxi implements PersistentStudentManageService{
    
    public StudentManageServiceICProxi(long objectId) {
        super(objectId);
    }
    public StudentManageServiceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade
            .getStudentManageService(this.getId());
    }
    
    public long getClassId() {
        return -303;
    }
    
    public void setStudentManager(StudentManageServiceStudentManager4Public newValue) throws PersistenceException {
        ((PersistentStudentManageService)this.getTheObject()).setStudentManager(newValue);
    }
    public PersistentStudentManageService getThis() throws PersistenceException {
        return ((PersistentStudentManageService)this.getTheObject()).getThis();
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).deregister(observee);
    }
    public StudentManager4Public getStudentManager() 
				throws PersistenceException{
        return ((PersistentStudentManageService)this.getTheObject()).getStudentManager();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException{
        return ((PersistentStudentManageService)this.getTheObject()).lecture_Path_In_ChangeGradeforStudent(student);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).register(observee);
    }
    public void setStudentManager(final StudentManager4Public studentManager) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).setStudentManager(studentManager);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).signalChanged(signal);
    }
    public String studentManageService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentStudentManageService)this.getTheObject()).studentManageService_Menu_Filter(anything);
    }
    public StudentSearchList students_Path_In_DeleteStudents(final StudentManager4Public manager) 
				throws model.UserException, PersistenceException{
        return ((PersistentStudentManageService)this.getTheObject()).students_Path_In_DeleteStudents(manager);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).updateObservers(event);
    }
    public void updatePLZ() 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).updatePLZ();
    }
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade, final String comment) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).changeGradeOfModule(module, grade, comment);
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final String comment) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).changeGradeOfUnit(unit, grade, comment);
    }
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade, final String comment) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).changeGradeforStudent(student, lecture, grade, comment);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deleteStudents(final StudentManager4Public manager, final StudentSearchList students) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).deleteStudents(manager, students);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentStudentManageService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).removeError(error);
    }
    public void studentManager_update(final model.meta.StudentManagerMssgs event) 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).studentManager_update(event);
    }
    public void updateMe() 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).updateMe();
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
        ((PersistentStudentManageService)this.getTheObject()).updatePLZImplementation();
    }

    
}
