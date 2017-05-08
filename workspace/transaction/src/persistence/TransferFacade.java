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
    public PersistentTransfer newTransfer(String description,common.Fraction amount,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newTrnsfr(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, description);
            callable.setString(3, amount.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(description,amount,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentTransfer)PersistentProxi.createProxi(id, 134);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentTransfer newDelayedTransfer(String description,common.Fraction amount) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newDelayedTrnsfr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(description,amount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentTransfer)PersistentProxi.createProxi(id, 134);
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
            PersistentAccount fromAcc = null;
            if (obj.getLong(4) != 0)
                fromAcc = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccount toAcc = null;
            if (obj.getLong(6) != 0)
                toAcc = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentTransfer This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentTransfer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Transfer result = new Transfer(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                           (obj.getString(3) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(3))),
                                           fromAcc,
                                           toAcc,
                                           This,
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
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.getClass(?); end;");
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
    public void descriptionSet(long TransferId, String descriptionVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.dscrptnSet(?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setString(2, descriptionVal);
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
    public void fromAccSet(long TransferId, Account4Public fromAccVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.frmAccSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, fromAccVal.getId());
            callable.setLong(3, fromAccVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void toAccSet(long TransferId, Account4Public toAccVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.tAccSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, toAccVal.getId());
            callable.setLong(3, toAccVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long TransferId, Transfer4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

