package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class T_1_0Facade{

	private String schemaName;
	private Connection con;

	public T_1_0Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentT_1_0 getTheT_1_0() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_1_0Facade.getTheT_1_0; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentT_1_0)PersistentProxi.createProxi(id, 221);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public T_1_0 getT_1_0(long T_1_0Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_1_0Facade.getT_1_0(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, T_1_0Id);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGradesInSimpleOrThird This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentGradesInSimpleOrThird)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            T_1_0 result = new T_1_0(This,
                                     T_1_0Id);
            obj.close();
            callable.close();
            T_1_0ICProxi inCache = (T_1_0ICProxi)Cache.getTheCache().put(result);
            T_1_0 objectInCache = (T_1_0)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

