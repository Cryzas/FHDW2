package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_1_8Facade{

	private String schemaName;
	private Connection con;

	public Z_1_8Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_1_8 getTheZ_1_8() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_1_8Facade.getTheZ_1_8; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_1_8)PersistentProxi.createProxi(id, 255);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_1_8 getZ_1_8(long Z_1_8Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_1_8Facade.getZ_1_8(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_1_8Id);
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
            Z_1_8 result = new Z_1_8(subService,
                                     This,
                                     Z_1_8Id);
            obj.close();
            callable.close();
            Z_1_8ICProxi inCache = (Z_1_8ICProxi)Cache.getTheCache().put(result);
            Z_1_8 objectInCache = (Z_1_8)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

