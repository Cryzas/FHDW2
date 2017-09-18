package model.meta;

public interface StudentManagerMssgsVisitor extends StudentManagerDOWNMssgsVisitor, StudentManagerUPMssgsVisitor {}


interface StudentManagerDOWNMssgsVisitor  {

    public void handleStudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg(StudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg event) throws persistence.PersistenceException;
    
}


interface StudentManagerUPMssgsVisitor  {

    public void handleStudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg(StudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg event) throws persistence.PersistenceException;
    
}
