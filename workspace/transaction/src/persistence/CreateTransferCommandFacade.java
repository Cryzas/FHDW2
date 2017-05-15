package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CreateTransferCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateTransferCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateTransferCommand newCreateTransferCommand(common.Fraction amount,String subject,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtTrnsfrCMDFacade.newCrtTrnsfrCMD(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, amount.toString());
            callable.setString(3, subject);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateTransferCommand result = new CreateTransferCommand(null,null,amount,subject,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentCreateTransferCommand)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCreateTransferCommand newDelayedCreateTransferCommand(common.Fraction amount,String subject) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtTrnsfrCMDFacade.newDelayedCrtTrnsfrCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateTransferCommand result = new CreateTransferCommand(null,null,amount,subject,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentCreateTransferCommand)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateTransferCommand getCreateTransferCommand(long CreateTransferCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtTrnsfrCMDFacade.getCrtTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CreateTransferCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccountHandle fromAccount = null;
            if (obj.getLong(2) != 0)
                fromAccount = (PersistentAccountHandle)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccountHandle toAccount = null;
            if (obj.getLong(4) != 0)
                toAccount = (PersistentAccountHandle)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(8) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentTransferManager commandReceiver = null;
            if (obj.getLong(10) != 0)
                commandReceiver = (PersistentTransferManager)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(12) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            CreateTransferCommand result = new CreateTransferCommand(fromAccount,
                                                                     toAccount,
                                                                     (obj.getString(6) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(6))),
                                                                     obj.getString(7) == null ? "" : obj.getString(7) /* In Oracle "" = null !!! */,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     CreateTransferCommandId);
            obj.close();
            callable.close();
            CreateTransferCommandICProxi inCache = (CreateTransferCommandICProxi)Cache.getTheCache().put(result);
            CreateTransferCommand objectInCache = (CreateTransferCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtTrnsfrCMDFacade.getClass(?); end;");
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
    public void fromAccountSet(long CreateTransferCommandId, AccountHandle4Public fromAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.frmAccntSet(?, ?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setLong(2, fromAccountVal.getId());
            callable.setLong(3, fromAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void toAccountSet(long CreateTransferCommandId, AccountHandle4Public toAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.tAccntSet(?, ?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setLong(2, toAccountVal.getId());
            callable.setLong(3, toAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long CreateTransferCommandId, common.Fraction amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.amntSet(?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setString(2, amountVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subjectSet(long CreateTransferCommandId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateTransferCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateTransferCommandId, TransferManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateTransferCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtTrnsfrCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateTransferCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

