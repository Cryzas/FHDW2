package model.meta;

public interface ModuleAtomarMssgsVisitor extends ModuleAtomarDOWNMssgsVisitor, ModuleAtomarUPMssgsVisitor {}


interface ModuleAtomarDOWNMssgsVisitor  {

    public void handleModuleAtomarChangeCPOnModuleFractionMssg(ModuleAtomarChangeCPOnModuleFractionMssg event) throws persistence.PersistenceException;
    
}


interface ModuleAtomarUPMssgsVisitor extends ModuleAbstractUPMssgsVisitor {

    public void handleModuleAtomarChangeCPOnModuleFractionMssg(ModuleAtomarChangeCPOnModuleFractionMssg event) throws persistence.PersistenceException;
    
}
