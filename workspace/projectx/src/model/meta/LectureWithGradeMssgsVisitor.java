package model.meta;

public interface LectureWithGradeMssgsVisitor extends LectureWithGradeDOWNMssgsVisitor, LectureWithGradeUPMssgsVisitor {}


interface LectureWithGradeDOWNMssgsVisitor extends UnitStudentDOWNMssgsVisitor, ModuleAtomarStudentDOWNMssgsVisitor, ModuleAbstractStudentUPMssgsVisitor {

    
}


interface LectureWithGradeUPMssgsVisitor  {

    
}
