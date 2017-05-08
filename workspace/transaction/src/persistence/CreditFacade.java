package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CreditFacade{

	private String schemaName;
	private Connection con;

	public CreditFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCredit newCredit(String description,common.Fraction amount,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrdtFacade.newCrdt(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, description);
            callable.setString(3, amount.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Credit result = new Credit(description,amount,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentCredit)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCredit newDelayedCredit(String description,common.Fraction amount) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrdtFacade.newDelayedCrdt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Credit result = new Credit(description,amount,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentCredit)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Credit getCredit(long CreditId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrdtFacade.getCrdt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CreditId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccount otherAcc = null;
            if (obj.getLong(4) != 0)
                otherAcc = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentEntry This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentEntry)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Credit result = new Credit(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                       (obj.getString(3) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(3))),
                                       otherAcc,
                                       This,
                                       CreditId);
            obj.close();
            callable.close();
            CreditICProxi inCache = (CreditICProxi)Cache.getTheCache().put(result);
            Credit objectInCache = (Credit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

