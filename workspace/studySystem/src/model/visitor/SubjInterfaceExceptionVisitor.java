
package model.visitor;
import persistence.*;

public interface SubjInterfaceExceptionVisitor<E extends model.UserException> extends GradeExceptionVisitor<E>,GradeSystemExceptionVisitor<E>,LectureWithGradeExceptionVisitor<E>,ModuleAbstractExceptionVisitor<E>,ModuleAbstractSGroupExceptionVisitor<E>,ModuleAbstractStudentExceptionVisitor<E>,MyBooleanExceptionVisitor<E>,ProgramStudentExceptionVisitor<E>,ServiceExceptionVisitor<E>,subAdminServiceExceptionVisitor<E>{
    
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException, E;
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public void handleProgram(Program4Public program) throws PersistenceException, E;
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException, E;
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleStudent(Student4Public student) throws PersistenceException, E;
    public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException, E;
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException, E;
    public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleUnit(Unit4Public unit) throws PersistenceException, E;
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException, E;
    
}
