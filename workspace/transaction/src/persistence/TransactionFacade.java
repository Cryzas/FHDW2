package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TransactionFacade{

	private String schemaName;
	private Connection con;

	public TransactionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentTransaction newTransaction(String subject,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.newTrnsctn(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, subject);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transaction result = new Transaction(subject,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentTransaction)PersistentProxi.createProxi(id, 135);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentTransaction newDelayedTransaction(String subject) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.newDelayedTrnsctn(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transaction result = new Transaction(subject,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentTransaction)PersistentProxi.createProxi(id, 135);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Transaction getTransaction(long TransactionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.getTrnsctn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TransactionId);
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
            Transaction result = new Transaction(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                 subService,
                                                 This,
                                                 TransactionId);
            obj.close();
            callable.close();
            TransactionICProxi inCache = (TransactionICProxi)Cache.getTheCache().put(result);
            Transaction objectInCache = (Transaction)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long transfersAdd(long TransactionId, Transfer4Public transfersVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.trnsfrsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, TransactionId);
            callable.setLong(3, transfersVal.getId());
            callable.setLong(4, transfersVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void transfersRem(long transfersId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsctnFacade.trnsfrsRem(?); end;");
            callable.setLong(1, transfersId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public TransferList transfersGet(long TransactionId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.trnsfrsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TransactionId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            TransferList result = new TransferList();
            while (list.next()) {
                result.add((PersistentTransfer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

