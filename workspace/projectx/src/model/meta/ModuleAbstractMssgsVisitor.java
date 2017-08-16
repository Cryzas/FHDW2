package model.meta;

public interface ModuleAbstractMssgsVisitor extends ModuleAbstractDOWNMssgsVisitor, ModuleAbstractUPMssgsVisitor {}


interface ModuleAbstractDOWNMssgsVisitor extends ModuleAtomarDOWNMssgsVisitor, ModuleWithUnitsDOWNMssgsVisitor, ModuleGroupDOWNMssgsVisitor {

    
}


interface ModuleAbstractUPMssgsVisitor  {

    
}
