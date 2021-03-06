
package view.visitor;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends GradeReturnExceptionVisitor<R, E> ,GradeSystemReturnExceptionVisitor<R, E> ,ModuleAbstractReturnExceptionVisitor<R, E> ,ModuleAbstractSGroupReturnExceptionVisitor<R, E> ,ModuleAbstractStudentReturnExceptionVisitor<R, E> ,MyBooleanReturnExceptionVisitor<R, E> ,ProgramStudentReturnExceptionVisitor<R, E> ,ServiceReturnExceptionVisitor<R, E> ,subAdminServiceReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleGradeChange(GradeChangeView gradeChange) throws ModelException, E;
    public R handleModuleManager(ModuleManagerView moduleManager) throws ModelException, E;
    public R handleProgram(ProgramView program) throws ModelException, E;
    public R handleProgramManager(ProgramManagerView programManager) throws ModelException, E;
    public R handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException, E;
    public R handleProgramStudent(ProgramStudentView programStudent) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleStudent(StudentView student) throws ModelException, E;
    public R handleStudentManager(StudentManagerView studentManager) throws ModelException, E;
    public R handleStudyGroup(StudyGroupView studyGroup) throws ModelException, E;
    public R handleStudyGroupManager(StudyGroupManagerView studyGroupManager) throws ModelException, E;
    public R handleUnit(UnitView unit) throws ModelException, E;
    public R handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException, E;
    public R handleUnitStudent(UnitStudentView unitStudent) throws ModelException, E;
    
}
