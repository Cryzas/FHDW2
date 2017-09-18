package model.meta;

import persistence.*;

public class ProgramManagerStartStudyGroupProgramStringMssg implements ProgramManagerDOWNMssgs,ProgramManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentProgramManager rcvr;
    public final persistence.Program4Public program;
    public final String name;
    
    public ProgramManagerStartStudyGroupProgramStringMssg(persistence.Program4Public program,
                                                          String name,
                                                          persistence.PersistentProgramManager rcvr){
        this.program = program;
        this.name = name;
        this.rcvr = rcvr;
    }
    public void accept(ProgramManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleProgramManagerStartStudyGroupProgramStringMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.startStudyGroupImplementation(this.program, this.name);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyExistsInParentException, model.NoFractionValueException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyExistsInParentException) throw (model.AlreadyExistsInParentException) this.excptn;
            if(this.excptn instanceof model.NoFractionValueException) throw (model.NoFractionValueException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
