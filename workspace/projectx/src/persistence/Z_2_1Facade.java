package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_2_1Facade{

	private String schemaName;
	private Connection con;

	public Z_2_1Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_2_1 getTheZ_2_1() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_2_1Facade.getTheZ_2_1; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_2_1)PersistentProxi.createProxi(id, 242);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_2_1 getZ_2_1(long Z_2_1Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_2_1Facade.getZ_2_1(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_2_1Id);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGradesInTenth This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentGradesInTenth)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Z_2_1 result = new Z_2_1(This,
                                     Z_2_1Id);
            obj.close();
            callable.close();
            Z_2_1ICProxi inCache = (Z_2_1ICProxi)Cache.getTheCache().put(result);
            Z_2_1 objectInCache = (Z_2_1)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

