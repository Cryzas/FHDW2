package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NoGradeSimpleFacade{

	private String schemaName;
	private Connection con;

	public NoGradeSimpleFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentNoGradeSimple getTheNoGradeSimple() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdSmplFacade.getTheNGrdSmpl; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentNoGradeSimple)PersistentProxi.createProxi(id, 218);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoGradeSimple getNoGradeSimple(long NoGradeSimpleId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdSmplFacade.getNGrdSmpl(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NoGradeSimpleId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGradesInSimple This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentGradesInSimple)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            NoGradeSimple result = new NoGradeSimple(This,
                                                     NoGradeSimpleId);
            obj.close();
            callable.close();
            NoGradeSimpleICProxi inCache = (NoGradeSimpleICProxi)Cache.getTheCache().put(result);
            NoGradeSimple objectInCache = (NoGradeSimple)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

