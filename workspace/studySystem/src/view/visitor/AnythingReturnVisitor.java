
package view.visitor;
import view.*;

public interface AnythingReturnVisitor<R> extends GradeReturnVisitor<R> ,GradeSystemReturnVisitor<R> ,ModuleAbstractReturnVisitor<R> ,ModuleAbstractSGroupReturnVisitor<R> ,ModuleAbstractStudentReturnVisitor<R> ,MyBooleanReturnVisitor<R> ,ProgramStudentReturnVisitor<R> ,ServiceReturnVisitor<R> ,subAdminServiceReturnVisitor<R> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleGradeChange(GradeChangeView gradeChange) throws ModelException;
    public R handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    public R handleProgram(ProgramView program) throws ModelException;
    public R handleProgramManager(ProgramManagerView programManager) throws ModelException;
    public R handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException;
    public R handleProgramStudent(ProgramStudentView programStudent) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleStudent(StudentView student) throws ModelException;
    public R handleStudentManager(StudentManagerView studentManager) throws ModelException;
    public R handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    public R handleStudyGroupManager(StudyGroupManagerView studyGroupManager) throws ModelException;
    public R handleUnit(UnitView unit) throws ModelException;
    public R handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException;
    public R handleUnitStudent(UnitStudentView unitStudent) throws ModelException;
    
}
