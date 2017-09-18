package model.meta;

public interface ModuleAtomarMssgsVisitor extends ModuleAtomarDOWNMssgsVisitor, ModuleAtomarUPMssgsVisitor {}


interface ModuleAtomarDOWNMssgsVisitor  {

    public void handleModuleAtomarChangeGradeSystemGradeSystemMssg(ModuleAtomarChangeGradeSystemGradeSystemMssg event) throws persistence.PersistenceException;
    
}


interface ModuleAtomarUPMssgsVisitor extends ModuleAbstractUPMssgsVisitor {

    public void handleModuleAtomarChangeGradeSystemGradeSystemMssg(ModuleAtomarChangeGradeSystemGradeSystemMssg event) throws persistence.PersistenceException;
    
}
