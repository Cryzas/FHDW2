package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends AdministratorDOWNMssgsVisitor, CustomerDOWNMssgsVisitor, RegisterDOWNMssgsVisitor, UserManagerDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
