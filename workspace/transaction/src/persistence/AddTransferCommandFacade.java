package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddTransferCommandFacade{

	private String schemaName;
	private Connection con;

	public AddTransferCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddTransferCommand newAddTransferCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTrnsfrCMDFacade.newAddTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddTransferCommand result = new AddTransferCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddTransferCommand)PersistentProxi.createProxi(id, 137);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddTransferCommand newDelayedAddTransferCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTrnsfrCMDFacade.newDelayedAddTrnsfrCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddTransferCommand result = new AddTransferCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddTransferCommand)PersistentProxi.createProxi(id, 137);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddTransferCommand getAddTransferCommand(long AddTransferCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTrnsfrCMDFacade.getAddTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddTransferCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentTransaction transaction = null;
            if (obj.getLong(2) != 0)
                transaction = (PersistentTransaction)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTransfer transfer = null;
            if (obj.getLong(4) != 0)
                transfer = (PersistentTransfer)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentTransferManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentTransferManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddTransferCommand result = new AddTransferCommand(transaction,
                                                               transfer,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               AddTransferCommandId);
            obj.close();
            callable.close();
            AddTransferCommandICProxi inCache = (AddTransferCommandICProxi)Cache.getTheCache().put(result);
            AddTransferCommand objectInCache = (AddTransferCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTrnsfrCMDFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void transactionSet(long AddTransferCommandId, Transaction4Public transactionVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTrnsfrCMDFacade.trnsctnSet(?, ?, ?); end;");
            callable.setLong(1, AddTransferCommandId);
            callable.setLong(2, transactionVal.getId());
            callable.setLong(3, transactionVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void transferSet(long AddTransferCommandId, Transfer4Public transferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTrnsfrCMDFacade.trnsfrSet(?, ?, ?); end;");
            callable.setLong(1, AddTransferCommandId);
            callable.setLong(2, transferVal.getId());
            callable.setLong(3, transferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddTransferCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTrnsfrCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddTransferCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddTransferCommandId, TransferManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTrnsfrCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddTransferCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddTransferCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTrnsfrCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddTransferCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

