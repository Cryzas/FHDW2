package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CreateMaterialCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateMaterialCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateMaterialCommand newCreateMaterialCommand(String name,common.Fraction price,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMtrlCMDFacade.newCrtMtrlCMD(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, price.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMaterialCommand result = new CreateMaterialCommand(name,price,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentCreateMaterialCommand)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCreateMaterialCommand newDelayedCreateMaterialCommand(String name,common.Fraction price) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMtrlCMDFacade.newDelayedCrtMtrlCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMaterialCommand result = new CreateMaterialCommand(name,price,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentCreateMaterialCommand)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMaterialCommand getCreateMaterialCommand(long CreateMaterialCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMtrlCMDFacade.getCrtMtrlCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CreateMaterialCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentPartsListManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentPartsListManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            CreateMaterialCommand result = new CreateMaterialCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                     (obj.getString(3) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(3))),
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     CreateMaterialCommandId);
            obj.close();
            callable.close();
            CreateMaterialCommandICProxi inCache = (CreateMaterialCommandICProxi)Cache.getTheCache().put(result);
            CreateMaterialCommand objectInCache = (CreateMaterialCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMtrlCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateMaterialCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMtrlCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateMaterialCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void priceSet(long CreateMaterialCommandId, common.Fraction priceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMtrlCMDFacade.prcSet(?, ?); end;");
            callable.setLong(1, CreateMaterialCommandId);
            callable.setString(2, priceVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateMaterialCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMtrlCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateMaterialCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateMaterialCommandId, PartsListManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMtrlCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateMaterialCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateMaterialCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMtrlCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateMaterialCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

