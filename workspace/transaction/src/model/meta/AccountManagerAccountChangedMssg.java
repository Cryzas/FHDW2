package model.meta;

import persistence.*;

public class AccountManagerAccountChangedMssg implements AccountManagerDOWNMssgs,AccountManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAccountManager rcvr;
    
    public AccountManagerAccountChangedMssg(persistence.PersistentAccountManager rcvr){
        this.rcvr = rcvr;
    }
    public void accept(AccountManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleAccountManagerAccountChangedMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.accountChangedImplementation();
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
