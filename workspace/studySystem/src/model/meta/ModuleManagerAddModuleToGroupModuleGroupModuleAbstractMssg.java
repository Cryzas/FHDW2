package model.meta;

import persistence.*;

public class ModuleManagerAddModuleToGroupModuleGroupModuleAbstractMssg implements ModuleManagerDOWNMssgs,ModuleManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleManager rcvr;
    public final persistence.ModuleGroup4Public group;
    public final persistence.ModuleAbstract4Public module;
    
    public ModuleManagerAddModuleToGroupModuleGroupModuleAbstractMssg(persistence.ModuleGroup4Public group,
                                                                      persistence.ModuleAbstract4Public module,
                                                                      persistence.PersistentModuleManager rcvr){
        this.group = group;
        this.module = module;
        this.rcvr = rcvr;
    }
    public void accept(ModuleManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleManagerAddModuleToGroupModuleGroupModuleAbstractMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.addModuleToGroupImplementation(this.group, this.module);
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
