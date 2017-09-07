package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NoGradeFacade{

	private String schemaName;
	private Connection con;

	public NoGradeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentNoGrade getTheNoGrade() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdFacade.getTheNGrd; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentNoGrade)PersistentProxi.createProxi(id, 273);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoGrade getNoGrade(long NoGradeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdFacade.getNGrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NoGradeId);
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
            NoGrade result = new NoGrade(This,
                                         NoGradeId);
            obj.close();
            callable.close();
            NoGradeICProxi inCache = (NoGradeICProxi)Cache.getTheCache().put(result);
            NoGrade objectInCache = (NoGrade)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

