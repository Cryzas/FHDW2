package model.meta;

public interface ContaineeMssgsVisitor extends ContaineeDOWNMssgsVisitor, ContaineeUPMssgsVisitor {}


interface ContaineeDOWNMssgsVisitor extends FileDOWNMssgsVisitor, DirectoryDOWNMssgsVisitor {

    
}


interface ContaineeUPMssgsVisitor  {

    
}
