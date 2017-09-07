package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_2_9Facade{

	private String schemaName;
	private Connection con;

	public Z_2_9Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_2_9 getTheZ_2_9() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_2_9Facade.getTheZ_2_9; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_2_9)PersistentProxi.createProxi(id, 238);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_2_9 getZ_2_9(long Z_2_9Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_2_9Facade.getZ_2_9(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_2_9Id);
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
            Z_2_9 result = new Z_2_9(This,
                                     Z_2_9Id);
            obj.close();
            callable.close();
            Z_2_9ICProxi inCache = (Z_2_9ICProxi)Cache.getTheCache().put(result);
            Z_2_9 objectInCache = (Z_2_9)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

