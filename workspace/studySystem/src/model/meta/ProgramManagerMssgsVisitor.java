package model.meta;

public interface ProgramManagerMssgsVisitor extends ProgramManagerDOWNMssgsVisitor, ProgramManagerUPMssgsVisitor {}


interface ProgramManagerDOWNMssgsVisitor  {

    public void handleProgramManagerAddModuleToProgProgramModuleAbstractMssg(ProgramManagerAddModuleToProgProgramModuleAbstractMssg event) throws persistence.PersistenceException;
    public void handleProgramManagerCreateProgramStringMssg(ProgramManagerCreateProgramStringMssg event) throws persistence.PersistenceException;
    public void handleProgramManagerStartStudyGroupProgramStringMssg(ProgramManagerStartStudyGroupProgramStringMssg event) throws persistence.PersistenceException;
    
}


interface ProgramManagerUPMssgsVisitor  {

    public void handleProgramManagerAddModuleToProgProgramModuleAbstractMssg(ProgramManagerAddModuleToProgProgramModuleAbstractMssg event) throws persistence.PersistenceException;
    public void handleProgramManagerCreateProgramStringMssg(ProgramManagerCreateProgramStringMssg event) throws persistence.PersistenceException;
    public void handleProgramManagerStartStudyGroupProgramStringMssg(ProgramManagerStartStudyGroupProgramStringMssg event) throws persistence.PersistenceException;
    
}
