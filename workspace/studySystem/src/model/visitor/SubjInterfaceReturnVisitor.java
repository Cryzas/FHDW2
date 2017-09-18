
package model.visitor;
import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends GradeReturnVisitor<R> ,GradeSystemReturnVisitor<R> ,LectureWithGradeReturnVisitor<R> ,ModuleAbstractReturnVisitor<R> ,ModuleAbstractSGroupReturnVisitor<R> ,ModuleAbstractStudentReturnVisitor<R> ,MyBooleanReturnVisitor<R> ,ProgramStudentReturnVisitor<R> ,ServiceReturnVisitor<R> ,subAdminServiceReturnVisitor<R> {
    
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public R handleProgram(Program4Public program) throws PersistenceException;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public R handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleStudent(Student4Public student) throws PersistenceException;
    public R handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    public R handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public R handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public R handleSubj(Subj4Public subj) throws PersistenceException;
    public R handleUnit(Unit4Public unit) throws PersistenceException;
    public R handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    
}
