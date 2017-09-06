package model.meta;

public interface GradesInSimpleMssgsVisitor extends GradesInSimpleDOWNMssgsVisitor, GradesInSimpleUPMssgsVisitor {}


interface GradesInSimpleDOWNMssgsVisitor extends PassedDOWNMssgsVisitor, NotPassedDOWNMssgsVisitor {

    
}


interface GradesInSimpleUPMssgsVisitor extends GradesInSimpleOrThirdUPMssgsVisitor {

    
}
