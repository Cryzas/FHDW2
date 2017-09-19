package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class T_3_7Facade{

	private String schemaName;
	private Connection con;

	public T_3_7Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentT_3_7 getTheT_3_7() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_3_7Facade.getTheT_3_7; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentT_3_7)PersistentProxi.createProxi(id, 225);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public T_3_7 getT_3_7(long T_3_7Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".T_3_7Facade.getT_3_7(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, T_3_7Id);
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
            T_3_7 result = new T_3_7(subService,
                                     This,
                                     T_3_7Id);
            obj.close();
            callable.close();
            T_3_7ICProxi inCache = (T_3_7ICProxi)Cache.getTheCache().put(result);
            T_3_7 objectInCache = (T_3_7)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

