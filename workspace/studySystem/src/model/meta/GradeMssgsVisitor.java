package model.meta;

public interface GradeMssgsVisitor extends GradeDOWNMssgsVisitor, GradeUPMssgsVisitor {}


interface GradeDOWNMssgsVisitor extends GradesInSimpleOrThirdDOWNMssgsVisitor, GradesInTenthDOWNMssgsVisitor {

    
}


interface GradeUPMssgsVisitor  {

    
}
