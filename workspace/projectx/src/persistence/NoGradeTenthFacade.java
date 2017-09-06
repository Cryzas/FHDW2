package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NoGradeTenthFacade{

	private String schemaName;
	private Connection con;

	public NoGradeTenthFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentNoGradeTenth getTheNoGradeTenth() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdTnthFacade.getTheNGrdTnth; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentNoGradeTenth)PersistentProxi.createProxi(id, 268);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoGradeTenth getNoGradeTenth(long NoGradeTenthId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NGrdTnthFacade.getNGrdTnth(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NoGradeTenthId);
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
            NoGradeTenth result = new NoGradeTenth(This,
                                                   NoGradeTenthId);
            obj.close();
            callable.close();
            NoGradeTenthICProxi inCache = (NoGradeTenthICProxi)Cache.getTheCache().put(result);
            NoGradeTenth objectInCache = (NoGradeTenth)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

