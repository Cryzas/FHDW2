package model.meta;

import persistence.*;

public class ModuleAtomarChangeGradeSystemGradeSystemMssg implements ModuleAtomarDOWNMssgs,ModuleAtomarUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleAtomar rcvr;
    public final persistence.GradeSystem4Public gradeSystem;
    
    public ModuleAtomarChangeGradeSystemGradeSystemMssg(persistence.GradeSystem4Public gradeSystem,
                                                        persistence.PersistentModuleAtomar rcvr){
        this.gradeSystem = gradeSystem;
        this.rcvr = rcvr;
    }
    public void accept(ModuleAtomarMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleAtomarChangeGradeSystemGradeSystemMssg(this);
    }
    public void accept(ModuleAbstractMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleAtomarChangeGradeSystemGradeSystemMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeGradeSystemImplementation(this.gradeSystem);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}