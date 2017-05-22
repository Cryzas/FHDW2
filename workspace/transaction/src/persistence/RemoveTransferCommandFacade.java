package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RemoveTransferCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveTransferCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRemoveTransferCommand newRemoveTransferCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvTrnsfrCMDFacade.newRmvTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveTransferCommand result = new RemoveTransferCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRemoveTransferCommand)PersistentProxi.createProxi(id, 138);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRemoveTransferCommand newDelayedRemoveTransferCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvTrnsfrCMDFacade.newDelayedRmvTrnsfrCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveTransferCommand result = new RemoveTransferCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRemoveTransferCommand)PersistentProxi.createProxi(id, 138);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveTransferCommand getRemoveTransferCommand(long RemoveTransferCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvTrnsfrCMDFacade.getRmvTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RemoveTransferCommandId);
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
            RemoveTransferCommand result = new RemoveTransferCommand(transaction,
                                                                     transfer,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     RemoveTransferCommandId);
            obj.close();
            callable.close();
            RemoveTransferCommandICProxi inCache = (RemoveTransferCommandICProxi)Cache.getTheCache().put(result);
            RemoveTransferCommand objectInCache = (RemoveTransferCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvTrnsfrCMDFacade.getClass(?); end;");
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
    public void transactionSet(long RemoveTransferCommandId, Transaction4Public transactionVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvTrnsfrCMDFacade.trnsctnSet(?, ?, ?); end;");
            callable.setLong(1, RemoveTransferCommandId);
            callable.setLong(2, transactionVal.getId());
            callable.setLong(3, transactionVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void transferSet(long RemoveTransferCommandId, Transfer4Public transferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvTrnsfrCMDFacade.trnsfrSet(?, ?, ?); end;");
            callable.setLong(1, RemoveTransferCommandId);
            callable.setLong(2, transferVal.getId());
            callable.setLong(3, transferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveTransferCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvTrnsfrCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveTransferCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveTransferCommandId, TransferManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvTrnsfrCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveTransferCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveTransferCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvTrnsfrCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveTransferCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

