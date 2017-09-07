package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class T_4_0Facade{

	private String schemaName;
	private Connection con;

	public T_4_0Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentT_4_0 getTheT_4_0() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_4_0Facade.getTheT_4_0; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentT_4_0)PersistentProxi.createProxi(id, 239);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public T_4_0 getT_4_0(long T_4_0Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_4_0Facade.getT_4_0(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, T_4_0Id);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGrade This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentGrade)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            T_4_0 result = new T_4_0(This,
                                     T_4_0Id);
            obj.close();
            callable.close();
            T_4_0ICProxi inCache = (T_4_0ICProxi)Cache.getTheCache().put(result);
            T_4_0 objectInCache = (T_4_0)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

