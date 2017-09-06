package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class T_3_3Facade{

	private String schemaName;
	private Connection con;

	public T_3_3Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentT_3_3 getTheT_3_3() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_3_3Facade.getTheT_3_3; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentT_3_3)PersistentProxi.createProxi(id, 263);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public T_3_3 getT_3_3(long T_3_3Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_3_3Facade.getT_3_3(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, T_3_3Id);
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
            T_3_3 result = new T_3_3(This,
                                     T_3_3Id);
            obj.close();
            callable.close();
            T_3_3ICProxi inCache = (T_3_3ICProxi)Cache.getTheCache().put(result);
            T_3_3 objectInCache = (T_3_3)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

