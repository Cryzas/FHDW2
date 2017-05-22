package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TransferFacade{

	private String schemaName;
	private Connection con;

	public TransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentTransfer newTransfer(String subject,common.Fraction amount,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newTrnsfr(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, subject);
            callable.setString(3, amount.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(subject,null,null,null,null,amount,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentTransfer)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentTransfer newDelayedTransfer(String subject,common.Fraction amount) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newDelayedTrnsfr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(subject,null,null,null,null,amount,id);
            Cache.getTheCache().put(result);
            return (PersistentTransfer)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Transfer getTransfer(long TransferId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.getTrnsfr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TransferId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(3) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentBookable This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentBookable)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAccount fromAccount = null;
            if (obj.getLong(7) != 0)
                fromAccount = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentAccount toAccount = null;
            if (obj.getLong(9) != 0)
                toAccount = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            Transfer result = new Transfer(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                           subService,
                                           This,
                                           fromAccount,
                                           toAccount,
                                           (obj.getString(11) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(11))),
                                           TransferId);
            obj.close();
            callable.close();
            TransferICProxi inCache = (TransferICProxi)Cache.getTheCache().put(result);
            Transfer objectInCache = (Transfer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void fromAccountSet(long TransferId, Account4Public fromAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.frmAccntSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, fromAccountVal.getId());
            callable.setLong(3, fromAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void toAccountSet(long TransferId, Account4Public toAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.tAccntSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, toAccountVal.getId());
            callable.setLong(3, toAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long TransferId, common.Fraction amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.amntSet(?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setString(2, amountVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

