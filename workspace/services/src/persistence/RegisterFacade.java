package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RegisterFacade{

	private String schemaName;
	private Connection con;

	public RegisterFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRegister newRegister(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RgstrFacade.newRgstr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Register result = new Register(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRegister)PersistentProxi.createProxi(id, -118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRegister newDelayedRegister() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RgstrFacade.newDelayedRgstr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Register result = new Register(null,id);
            Cache.getTheCache().put(result);
            return (PersistentRegister)PersistentProxi.createProxi(id, -118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Register getRegister(long RegisterId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RgstrFacade.getRgstr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RegisterId);
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
            Register result = new Register(This,
                                           RegisterId);
            obj.close();
            callable.close();
            RegisterICProxi inCache = (RegisterICProxi)Cache.getTheCache().put(result);
            Register objectInCache = (Register)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

