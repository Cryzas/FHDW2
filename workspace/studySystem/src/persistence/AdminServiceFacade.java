package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AdminServiceFacade{

	private String schemaName;
	private Connection con;

	public AdminServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAdminService newAdminService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvcFacade.newAdmnSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdminService result = new AdminService(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAdminService)PersistentProxi.createProxi(id, -289);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAdminService newDelayedAdminService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvcFacade.newDelayedAdmnSrvc(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdminService result = new AdminService(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAdminService)PersistentProxi.createProxi(id, -289);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdminService getAdminService(long AdminServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvcFacade.getAdmnSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AdminServiceId);
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
            PersistentService This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAdminServiceServices services = null;
            if (obj.getLong(6) != 0)
                services = (PersistentAdminServiceServices)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AdminService result = new AdminService(subService,
                                                   This,
                                                   services,
                                                   AdminServiceId);
            obj.close();
            callable.close();
            AdminServiceICProxi inCache = (AdminServiceICProxi)Cache.getTheCache().put(result);
            AdminService objectInCache = (AdminService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void servicesSet(long AdminServiceId, AdminServiceServices4Public servicesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvcFacade.srvcsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServiceId);
            callable.setLong(2, servicesVal.getId());
            callable.setLong(3, servicesVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

