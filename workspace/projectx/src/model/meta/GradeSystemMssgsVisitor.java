package model.meta;

public interface GradeSystemMssgsVisitor extends GradeSystemDOWNMssgsVisitor, GradeSystemUPMssgsVisitor {}


interface GradeSystemDOWNMssgsVisitor extends ThirdGradeDOWNMssgsVisitor, SimpleGradeDOWNMssgsVisitor, TenthGradeDOWNMssgsVisitor {

    
}


interface GradeSystemUPMssgsVisitor  {

    
}
