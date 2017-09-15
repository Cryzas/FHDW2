package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends StudentServiceDOWNMssgsVisitor, DozentenServiceDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
