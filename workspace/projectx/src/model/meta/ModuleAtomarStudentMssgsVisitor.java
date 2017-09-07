package model.meta;

public interface ModuleAtomarStudentMssgsVisitor extends ModuleAtomarStudentDOWNMssgsVisitor, ModuleAtomarStudentUPMssgsVisitor {}


interface ModuleAtomarStudentDOWNMssgsVisitor  {

    
}


interface ModuleAtomarStudentUPMssgsVisitor extends ModuleAbstractStudentUPMssgsVisitor, LectureWithGradeUPMssgsVisitor {

    
}
