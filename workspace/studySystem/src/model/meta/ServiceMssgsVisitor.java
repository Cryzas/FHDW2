package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends AdminServiceDOWNMssgsVisitor, StudentServiceDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
