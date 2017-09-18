package model.meta;

import persistence.*;

public class AccountWrpprAccountChangedAccountMssg implements AccountWrpprDOWNMssgs,AccountWrpprUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAccountWrppr rcvr;
    public final persistence.Account4Public account;
    
    public AccountWrpprAccountChangedAccountMssg(persistence.Account4Public account,
                                                 persistence.PersistentAccountWrppr rcvr){
        this.account = account;
        this.rcvr = rcvr;
    }
    public void accept(AccountWrpprMssgsVisitor visitor) throws PersistenceException{
        visitor.handleAccountWrpprAccountChangedAccountMssg(this);
    }
    public void accept(AccountHandleMssgsVisitor visitor) throws PersistenceException{
        visitor.handleAccountWrpprAccountChangedAccountMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.accountChangedImplementation(this.account);
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
