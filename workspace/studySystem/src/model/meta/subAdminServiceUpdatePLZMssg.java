package model.meta;

import persistence.*;

public class subAdminServiceUpdatePLZMssg implements subAdminServiceDOWNMssgs,subAdminServiceUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentsubAdminService rcvr;
    
    public subAdminServiceUpdatePLZMssg(persistence.PersistentsubAdminService rcvr){
        this.rcvr = rcvr;
    }
    public void accept(subAdminServiceMssgsVisitor visitor) throws PersistenceException{
        visitor.handlesubAdminServiceUpdatePLZMssg(this);
    }
    public void accept(StudentManageServiceMssgsVisitor visitor) throws PersistenceException{
        visitor.handlesubAdminServiceUpdatePLZMssg(this);
    }
    public void accept(UserManagerServiceMssgsVisitor visitor) throws PersistenceException{
        visitor.handlesubAdminServiceUpdatePLZMssg(this);
    }
    public void accept(ProgramModuleServiceMssgsVisitor visitor) throws PersistenceException{
        visitor.handlesubAdminServiceUpdatePLZMssg(this);
    }
    public void accept(StudyGroupServiceMssgsVisitor visitor) throws PersistenceException{
        visitor.handlesubAdminServiceUpdatePLZMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.updatePLZImplementation();
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
