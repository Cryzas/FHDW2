package model.meta;

import persistence.*;

public class ProgramManagerCreateProgramStringMssg implements ProgramManagerDOWNMssgs,ProgramManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentProgramManager rcvr;
    public final String name;
    
    public ProgramManagerCreateProgramStringMssg(String name,
                                                 persistence.PersistentProgramManager rcvr){
        this.name = name;
        this.rcvr = rcvr;
    }
    public void accept(ProgramManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleProgramManagerCreateProgramStringMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.createProgramImplementation(this.name);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyExistsInParentException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyExistsInParentException) throw (model.AlreadyExistsInParentException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
