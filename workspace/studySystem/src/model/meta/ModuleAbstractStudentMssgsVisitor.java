package model.meta;

public interface ModuleAbstractStudentMssgsVisitor extends ModuleAbstractStudentDOWNMssgsVisitor, ModuleAbstractStudentUPMssgsVisitor {}


interface ModuleAbstractStudentDOWNMssgsVisitor extends ModuleAtomarStudentDOWNMssgsVisitor, ModuleWithUnitsStudentDOWNMssgsVisitor, ModuleGroupStudentDOWNMssgsVisitor, LectureWithGradeUPMssgsVisitor {

    
}


interface ModuleAbstractStudentUPMssgsVisitor  {

    
}
