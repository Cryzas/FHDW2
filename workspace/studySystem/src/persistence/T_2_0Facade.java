package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class T_2_0Facade{

	private String schemaName;
	private Connection con;

	public T_2_0Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentT_2_0 getTheT_2_0() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_2_0Facade.getTheT_2_0; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentT_2_0)PersistentProxi.createProxi(id, 223);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public T_2_0 getT_2_0(long T_2_0Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_2_0Facade.getT_2_0(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, T_2_0Id);
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
            PersistentGrade This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentGrade)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            T_2_0 result = new T_2_0(subService,
                                     This,
                                     T_2_0Id);
            obj.close();
            callable.close();
            T_2_0ICProxi inCache = (T_2_0ICProxi)Cache.getTheCache().put(result);
            T_2_0 objectInCache = (T_2_0)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

