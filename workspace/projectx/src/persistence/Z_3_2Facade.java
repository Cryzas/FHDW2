package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_3_2Facade{

	private String schemaName;
	private Connection con;

	public Z_3_2Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_3_2 getTheZ_3_2() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_3_2Facade.getTheZ_3_2; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_3_2)PersistentProxi.createProxi(id, 246);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_3_2 getZ_3_2(long Z_3_2Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_3_2Facade.getZ_3_2(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_3_2Id);
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
            Z_3_2 result = new Z_3_2(This,
                                     Z_3_2Id);
            obj.close();
            callable.close();
            Z_3_2ICProxi inCache = (Z_3_2ICProxi)Cache.getTheCache().put(result);
            Z_3_2 objectInCache = (Z_3_2)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}
