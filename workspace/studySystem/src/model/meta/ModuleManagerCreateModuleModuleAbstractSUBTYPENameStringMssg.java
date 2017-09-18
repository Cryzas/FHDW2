package model.meta;

import persistence.*;

public class ModuleManagerCreateModuleModuleAbstractSUBTYPENameStringMssg implements ModuleManagerDOWNMssgs,ModuleManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleManager rcvr;
    public final String type;
    public final String name;
    
    public ModuleManagerCreateModuleModuleAbstractSUBTYPENameStringMssg(String type,
                                                                        String name,
                                                                        persistence.PersistentModuleManager rcvr){
        this.type = type;
        this.name = name;
        this.rcvr = rcvr;
    }
    public void accept(ModuleManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleManagerCreateModuleModuleAbstractSUBTYPENameStringMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.createModuleImplementation(this.type, this.name);
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
