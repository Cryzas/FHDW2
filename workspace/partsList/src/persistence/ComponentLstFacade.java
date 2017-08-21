package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ComponentLstFacade{

	private String schemaName;
	private Connection con;

	public ComponentLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentComponentLst newComponentLst(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.newCmpnntLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ComponentLst result = new ComponentLst(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentComponentLst)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentComponentLst newDelayedComponentLst() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.newDelayedCmpnntLst(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ComponentLst result = new ComponentLst(null,id);
            Cache.getTheCache().put(result);
            return (PersistentComponentLst)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ComponentLst getComponentLst(long ComponentLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.getCmpnntLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ComponentLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentComponentLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentComponentLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            ComponentLst result = new ComponentLst(This,
                                                   ComponentLstId);
            obj.close();
            callable.close();
            ComponentLstICProxi inCache = (ComponentLstICProxi)Cache.getTheCache().put(result);
            ComponentLst objectInCache = (ComponentLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.getClass(?); end;");
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
    public PersistentQuantifiedComponent partsAdd(long ComponentLstId, Component4Public indxxVal, QuantifiedComponent4Public partsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.prtsAdd(?, ?, ?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ComponentLstId);
            callable.setLong(3, indxxVal.getId());
            callable.setLong(4, indxxVal.getClassId());
            callable.setLong(5, partsVal.getId());
            callable.setLong(6, partsVal.getClassId());
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentQuantifiedComponent result = null;
            if (list.next()) result = (PersistentQuantifiedComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentQuantifiedComponent partsRem(long ComponentLstId, Component4Public indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.prtsRem(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ComponentLstId);
            callable.setLong(3, indxxVal.getId());
            callable.setLong(4, indxxVal.getClassId());
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentQuantifiedComponent result = null;
            if (list.next()) result = (PersistentQuantifiedComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void partsRemEntr(long partsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnntLstFacade.prtsRemEntr(?); end;");
            callable.setLong(1, partsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentQuantifiedComponent partsGet(long ComponentLstId, Component4Public indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.prtsGet(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ComponentLstId);
            callable.setLong(3, indxxVal.getId());
            callable.setLong(4, indxxVal.getClassId());
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentQuantifiedComponent result = null;
            if (list.next()) result = (PersistentQuantifiedComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public java.util.Hashtable<Component4Public,QuantifiedComponent4Public> partsGetValues(long ComponentLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntLstFacade.prtsGetValues(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ComponentLstId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            java.util.Hashtable<Component4Public,QuantifiedComponent4Public> result = new java.util.Hashtable<Component4Public,QuantifiedComponent4Public>();
            while (list.next()) {
                QuantifiedComponent4Public value = (QuantifiedComponent4Public)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
                Component4Public key = (Component4Public) PersistentProxi.createProxi(list.getLong(4),list.getLong(5));;
                result.put(key,value);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ComponentLstId, ComponentLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnntLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ComponentLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

