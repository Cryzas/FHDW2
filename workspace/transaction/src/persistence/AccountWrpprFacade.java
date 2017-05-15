package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AccountWrpprFacade{

	private String schemaName;
	private Connection con;

	public AccountWrpprFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountWrppr newAccountWrppr(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntWrpprFacade.newAccntWrppr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountWrppr result = new AccountWrppr(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAccountWrppr)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAccountWrppr newDelayedAccountWrppr() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntWrpprFacade.newDelayedAccntWrppr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountWrppr result = new AccountWrppr(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAccountWrppr)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountWrppr getAccountWrppr(long AccountWrpprId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntWrpprFacade.getAccntWrppr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AccountWrpprId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccountHandle This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountHandle)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccount account = null;
            if (obj.getLong(6) != 0)
                account = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AccountWrppr result = new AccountWrppr(subService,
                                                   This,
                                                   account,
                                                   AccountWrpprId);
            obj.close();
            callable.close();
            AccountWrpprICProxi inCache = (AccountWrpprICProxi)Cache.getTheCache().put(result);
            AccountWrppr objectInCache = (AccountWrppr)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountSet(long AccountWrpprId, Account4Public accountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntWrpprFacade.accntSet(?, ?, ?); end;");
            callable.setLong(1, AccountWrpprId);
            callable.setLong(2, accountVal.getId());
            callable.setLong(3, accountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

