package model.meta;

public interface ProgramManagerMssgsVisitor extends ProgramManagerDOWNMssgsVisitor, ProgramManagerUPMssgsVisitor {}


interface ProgramManagerDOWNMssgsVisitor  {

    public void handleProgramManagerStartStudyGroupProgramStringMssg(ProgramManagerStartStudyGroupProgramStringMssg event) throws persistence.PersistenceException;
    
}


interface ProgramManagerUPMssgsVisitor  {

    public void handleProgramManagerStartStudyGroupProgramStringMssg(ProgramManagerStartStudyGroupProgramStringMssg event) throws persistence.PersistenceException;
    
}
