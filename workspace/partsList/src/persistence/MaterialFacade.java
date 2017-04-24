package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class MaterialFacade{

	private String schemaName;
	private Connection con;

	public MaterialFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentMaterial newMaterial(String name,common.Fraction price,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrlFacade.newMtrl(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, price.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Material result = new Material(name,price,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentMaterial)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentMaterial newDelayedMaterial(String name,common.Fraction price) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrlFacade.newDelayedMtrl(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Material result = new Material(name,price,null,id);
            Cache.getTheCache().put(result);
            return (PersistentMaterial)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Material getMaterial(long MaterialId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrlFacade.getMtrl(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, MaterialId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentComponent This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Material result = new Material(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                           (obj.getString(3) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(3))),
                                           This,
                                           MaterialId);
            obj.close();
            callable.close();
            MaterialICProxi inCache = (MaterialICProxi)Cache.getTheCache().put(result);
            Material objectInCache = (Material)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

