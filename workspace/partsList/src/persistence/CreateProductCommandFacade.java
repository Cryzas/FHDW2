package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CreateProductCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateProductCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateProductCommand newCreateProductCommand(String name,common.Fraction price,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctCMDFacade.newCrtPrdctCMD(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, price.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateProductCommand result = new CreateProductCommand(name,price,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentCreateProductCommand)PersistentProxi.createProxi(id, 123);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCreateProductCommand newDelayedCreateProductCommand(String name,common.Fraction price) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctCMDFacade.newDelayedCrtPrdctCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateProductCommand result = new CreateProductCommand(name,price,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentCreateProductCommand)PersistentProxi.createProxi(id, 123);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateProductCommand getCreateProductCommand(long CreateProductCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctCMDFacade.getCrtPrdctCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CreateProductCommandId);
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
            CreateProductCommand result = new CreateProductCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                   (obj.getString(3) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(3))),
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   CreateProductCommandId);
            obj.close();
            callable.close();
            CreateProductCommandICProxi inCache = (CreateProductCommandICProxi)Cache.getTheCache().put(result);
            CreateProductCommand objectInCache = (CreateProductCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateProductCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateProductCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void priceSet(long CreateProductCommandId, common.Fraction priceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctCMDFacade.prcSet(?, ?); end;");
            callable.setLong(1, CreateProductCommandId);
            callable.setString(2, priceVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateProductCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateProductCommandId, PartsListManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateProductCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

