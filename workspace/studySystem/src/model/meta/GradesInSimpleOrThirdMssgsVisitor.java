package model.meta;

public interface GradesInSimpleOrThirdMssgsVisitor extends GradesInSimpleOrThirdDOWNMssgsVisitor, GradesInSimpleOrThirdUPMssgsVisitor {}


interface GradesInSimpleOrThirdDOWNMssgsVisitor extends GradesInSimpleDOWNMssgsVisitor, GradesInThirdDOWNMssgsVisitor {

    
}


interface GradesInSimpleOrThirdUPMssgsVisitor extends GradeUPMssgsVisitor {

    
}
