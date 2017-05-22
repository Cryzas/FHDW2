package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AdministratorFacade{

	private String schemaName;
	private Connection con;

	public AdministratorFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAdministrator newAdministrator(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrFacade.newAdmnstrtr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Administrator result = new Administrator(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAdministrator)PersistentProxi.createProxi(id, -114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAdministrator newDelayedAdministrator() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrFacade.newDelayedAdmnstrtr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Administrator result = new Administrator(null,id);
            Cache.getTheCache().put(result);
            return (PersistentAdministrator)PersistentProxi.createProxi(id, -114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Administrator getAdministrator(long AdministratorId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrFacade.getAdmnstrtr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AdministratorId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentService This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Administrator result = new Administrator(This,
                                                     AdministratorId);
            obj.close();
            callable.close();
            AdministratorICProxi inCache = (AdministratorICProxi)Cache.getTheCache().put(result);
            Administrator objectInCache = (Administrator)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

