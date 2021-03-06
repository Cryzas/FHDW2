package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_2_8Facade{

	private String schemaName;
	private Connection con;

	public Z_2_8Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_2_8 getTheZ_2_8() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_2_8Facade.getTheZ_2_8; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_2_8)PersistentProxi.createProxi(id, 237);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_2_8 getZ_2_8(long Z_2_8Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_2_8Facade.getZ_2_8(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_2_8Id);
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
            Z_2_8 result = new Z_2_8(subService,
                                     This,
                                     Z_2_8Id);
            obj.close();
            callable.close();
            Z_2_8ICProxi inCache = (Z_2_8ICProxi)Cache.getTheCache().put(result);
            Z_2_8 objectInCache = (Z_2_8)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

