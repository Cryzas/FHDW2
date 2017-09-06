package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NoGradeThirdFacade{

	private String schemaName;
	private Connection con;

	public NoGradeThirdFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentNoGradeThird getTheNoGradeThird() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdThrdFacade.getTheNGrdThrd; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentNoGradeThird)PersistentProxi.createProxi(id, 217);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoGradeThird getNoGradeThird(long NoGradeThirdId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdThrdFacade.getNGrdThrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NoGradeThirdId);
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
            NoGradeThird result = new NoGradeThird(This,
                                                   NoGradeThirdId);
            obj.close();
            callable.close();
            NoGradeThirdICProxi inCache = (NoGradeThirdICProxi)Cache.getTheCache().put(result);
            NoGradeThird objectInCache = (NoGradeThird)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

