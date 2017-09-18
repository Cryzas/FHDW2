package model.meta;

import persistence.*;

public class ModuleManagerChangeGradeSystemModuleAtomarMssg implements ModuleManagerDOWNMssgs,ModuleManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleManager rcvr;
    public final persistence.ModuleAtomar4Public module;
    
    public ModuleManagerChangeGradeSystemModuleAtomarMssg(persistence.ModuleAtomar4Public module,
                                                          persistence.PersistentModuleManager rcvr){
        this.module = module;
        this.rcvr = rcvr;
    }
    public void accept(ModuleManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleManagerChangeGradeSystemModuleAtomarMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeGradeSystemImplementation(this.module);
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
