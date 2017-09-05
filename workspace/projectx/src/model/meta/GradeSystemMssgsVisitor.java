package model.meta;

public interface GradeSystemMssgsVisitor extends GradeSystemDOWNMssgsVisitor, GradeSystemUPMssgsVisitor {}


interface GradeSystemDOWNMssgsVisitor extends ThirdGradeSystemDOWNMssgsVisitor, SimpleGradeSystemDOWNMssgsVisitor {

    
}


interface GradeSystemUPMssgsVisitor  {

    
}
