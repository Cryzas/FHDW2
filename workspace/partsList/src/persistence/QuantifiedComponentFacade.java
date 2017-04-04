package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class QuantifiedComponentFacade{

	private String schemaName;
	private Connection con;

	public QuantifiedComponentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentQuantifiedComponent newQuantifiedComponent(long quantity,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".QntfdCmpnntFacade.newQntfdCmpnnt(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, quantity);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            QuantifiedComponent result = new QuantifiedComponent(quantity,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentQuantifiedComponent)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentQuantifiedComponent newDelayedQuantifiedComponent(long quantity) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".QntfdCmpnntFacade.newDelayedQntfdCmpnnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            QuantifiedComponent result = new QuantifiedComponent(quantity,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentQuantifiedComponent)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public QuantifiedComponent getQuantifiedComponent(long QuantifiedComponentId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QntfdCmpnntFacade.getQntfdCmpnnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, QuantifiedComponentId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentComponent component = null;
            if (obj.getLong(3) != 0)
                component = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentQuantifiedComponent This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentQuantifiedComponent)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            QuantifiedComponent result = new QuantifiedComponent(obj.getLong(2),
                                                                 component,
                                                                 This,
                                                                 QuantifiedComponentId);
            obj.close();
            callable.close();
            QuantifiedComponentICProxi inCache = (QuantifiedComponentICProxi)Cache.getTheCache().put(result);
            QuantifiedComponent objectInCache = (QuantifiedComponent)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QntfdCmpnntFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void quantitySet(long QuantifiedComponentId, long quantityVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QntfdCmpnntFacade.qnttSet(?, ?); end;");
            callable.setLong(1, QuantifiedComponentId);
            callable.setLong(2, quantityVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void componentSet(long QuantifiedComponentId, Component4Public componentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QntfdCmpnntFacade.cmpnntSet(?, ?, ?); end;");
            callable.setLong(1, QuantifiedComponentId);
            callable.setLong(2, componentVal.getId());
            callable.setLong(3, componentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long QuantifiedComponentId, QuantifiedComponent4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QntfdCmpnntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, QuantifiedComponentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

