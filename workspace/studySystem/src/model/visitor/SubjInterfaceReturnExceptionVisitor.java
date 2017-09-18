
package model.visitor;
import persistence.*;

public interface SubjInterfaceReturnExceptionVisitor<R, E extends model.UserException> extends GradeReturnExceptionVisitor<R, E> ,GradeSystemReturnExceptionVisitor<R, E> ,LectureWithGradeReturnExceptionVisitor<R, E> ,ModuleAbstractReturnExceptionVisitor<R, E> ,ModuleAbstractSGroupReturnExceptionVisitor<R, E> ,ModuleAbstractStudentReturnExceptionVisitor<R, E> ,MyBooleanReturnExceptionVisitor<R, E> ,ProgramStudentReturnExceptionVisitor<R, E> ,ServiceReturnExceptionVisitor<R, E> ,subAdminServiceReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException, E;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public R handleProgram(Program4Public program) throws PersistenceException, E;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public R handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException, E;
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleStudent(Student4Public student) throws PersistenceException, E;
    public R handleStudentManager(StudentManager4Public studentManager) throws PersistenceException, E;
    public R handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException, E;
    public R handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException, E;
    public R handleSubj(Subj4Public subj) throws PersistenceException, E;
    public R handleUnit(Unit4Public unit) throws PersistenceException, E;
    public R handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException, E;
    
}
