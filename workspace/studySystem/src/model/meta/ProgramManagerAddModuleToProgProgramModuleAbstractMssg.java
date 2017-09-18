package model.meta;

import persistence.*;

public class ProgramManagerAddModuleToProgProgramModuleAbstractMssg implements ProgramManagerDOWNMssgs,ProgramManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentProgramManager rcvr;
    public final persistence.Program4Public program;
    public final persistence.ModuleAbstract4Public module;
    
    public ProgramManagerAddModuleToProgProgramModuleAbstractMssg(persistence.Program4Public program,
                                                                  persistence.ModuleAbstract4Public module,
                                                                  persistence.PersistentProgramManager rcvr){
        this.program = program;
        this.module = module;
        this.rcvr = rcvr;
    }
    public void accept(ProgramManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleProgramManagerAddModuleToProgProgramModuleAbstractMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.addModuleToProgImplementation(this.program, this.module);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyExistsInParentException) throw (model.AlreadyExistsInParentException) this.excptn;
            if(this.excptn instanceof model.CycleException) throw (model.CycleException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
