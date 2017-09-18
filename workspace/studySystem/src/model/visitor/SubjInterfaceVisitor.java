
package model.visitor;
import persistence.*;

public interface SubjInterfaceVisitor extends GradeVisitor,GradeSystemVisitor,LectureWithGradeVisitor,ModuleAbstractVisitor,ModuleAbstractSGroupVisitor,ModuleAbstractStudentVisitor,MyBooleanVisitor,ProgramStudentVisitor,ServiceVisitor,subAdminServiceVisitor{
    
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException;
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public void handleProgram(Program4Public program) throws PersistenceException;
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleStudent(Student4Public student) throws PersistenceException;
    public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public void handleSubj(Subj4Public subj) throws PersistenceException;
    public void handleUnit(Unit4Public unit) throws PersistenceException;
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    
}
