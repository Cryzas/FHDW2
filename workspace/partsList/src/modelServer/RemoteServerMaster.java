package modelServer;

import persistence.AbstractPersistentRoot;
import persistence.PersistentProxiInterface;
import persistence.PersistenceException;
import persistence.PersistentProxi;
import persistence.Remote;
import model.UserException;


import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.XmlRpcRequestProcessor;
import org.apache.xmlrpc.XmlRpcResponseProcessor;

import common.RPCConstantsAndServices;
import common.ProxiInformation;
import common.Fraction;
import common.CryptoConstants;

public abstract class RemoteServerMaster {

	protected static HashMap<String,Object> createOKResult(AbstractPersistentRoot object, int depth){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		if(object == null)result.put(RPCConstantsAndServices.ResultFieldName, 
									 RPCConstantsAndServices.createProxiRepresentation(RPCConstantsAndServices.NullClassID, 
																							  RPCConstantsAndServices.NullObjectID,
																							  RPCConstantsAndServices.NullIconInfo,
																							  RPCConstantsAndServices.NullLeafInfo,
																							  RPCConstantsAndServices.NullObjectToString));
		else
			try {
				result.put(RPCConstantsAndServices.ResultFieldName, object.toHashtable(depth, 0, false));
				result.put(RPCConstantsAndServices.RootFieldName, ((PersistentProxiInterface)object).createProxiInformation(false, true));
			} catch (PersistenceException e) {
				return createExceptionResult(e);
			}
		return result;
	}

	protected static HashMap<String,Object> createOKResult(HashMap<String,Object> contents){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultFieldName, contents);
		return result;
	}
	protected static HashMap<String,Object> createOKResult(Vector<?> list){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultListFieldName, list);
		return result;
	}
	protected static HashMap<String,Object> createOKResult(long integer){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultFieldName, new Long(integer).toString());
		return result;
	}
	protected static HashMap<String,Object> createOKResult(Fraction fraction){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultFieldName, fraction.toString());
		return result;
	}
	
	private static HashMap<String,Object> createOKResult(boolean b) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultFieldName, new Boolean(b));
		return result;
	}
	protected static HashMap<String,Object> createOKResult(java.util.Date date){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultFieldName, date);
		return result;
	}
	protected static HashMap<String,Object> createOKResult(String string){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(RPCConstantsAndServices.ResultFieldName, string);
		return result;
	}
	protected static HashMap<String,Object> createOKResult(){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		return result;
	}
	protected static HashMap<String,Object> createExceptionResult(PersistenceException exception){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(false));
		result.put(RPCConstantsAndServices.ErrorNumberFieldName, RPCConstantsAndServices.PersistenceExceptionNumber);
		result.put(RPCConstantsAndServices.ExceptionMessageFieldName, exception.getMessage());
		result.put(RPCConstantsAndServices.ExceptionNumberFieldName, new Integer(exception.getErrorNumber()));
		return result;
	}
	protected static HashMap<String,Object> createExceptionResult(UserException exception){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(false));
		result.put(RPCConstantsAndServices.ErrorNumberFieldName, new Integer((int)exception.getClassId()));
		try {
			result.put(RPCConstantsAndServices.ResultFieldName, exception.toHashtable(null, 1, 0, false, true, false));
		}catch(PersistenceException pe){
			return createExceptionResult(pe);
		}
		return result;
	}

	protected Date lastUsedDate;
	private String connectionName;
	private String userName;
	private String downTimeUntil = null;

	

	public RemoteServerMaster(String connectionName, String userName){
		this.connectionName = connectionName;
		this.userName = userName;
		this.lastUsedDate = new Date();
	}

	public boolean isDown(){
		return this.downTimeUntil != null;
	}
	public void setDown(String until){
		this.downTimeUntil = until;
	}

	abstract protected Remote getServer();

	public String toString(){
		return "Connection: " +
				this.connectionName +
				" ;  Server class: " +
				this.getServer().getClassId() +
				" Server object: " +
				this.getServer().getId() +
				" User: " +
				this.getUserName();
	}

	protected String getConnectionName(){
		return this.connectionName;
	}
	protected String getUserName(){
		return this.userName;
	}
	protected long getServerId(){
		return this.getServer().getId();
	}
	protected long getServerClassId(){
		return this.getServer().getClassId();
	}
	protected boolean isNotUsed(Date date){
		if (date.getTime() - this.lastUsedDate.getTime() > ConnectionServer.NotUsedInterval)return true;
		return false;
	}
	public synchronized HashMap<String,Object> hasChanged(){
		try{
			boolean result = this.getServer().hasChanged();
			return createOKResult(result);
		}catch(PersistenceException pe){
			return createExceptionResult(pe);
		}
	}
	@SuppressWarnings("unchecked")
	public synchronized HashMap<String,Object> getObject(int depth, Vector<String> context, boolean forGUI, String proxiInfo){
		try {
			ProxiInformation proxiInformation = RPCConstantsAndServices.createProxiInformation(proxiInfo);
			PersistentProxiInterface proxi = PersistentProxi.createProxi(proxiInformation);
			this.authorise(proxi);
			HashMap<String, Object> result = proxi.toHashtable(depth, 0, forGUI);
			for (String currentContextInfo : context) {
				ProxiInformation currentProxiInformation = RPCConstantsAndServices.createProxiInformation(currentContextInfo);
				PersistentProxiInterface currentProxi = PersistentProxi.createProxi(currentProxiInformation);
				this.authorise(currentProxi);
				try {
					currentProxi.toHashtable(result, new Integer(currentProxiInformation.getToString()), 0, forGUI, true, false);
				} catch (PersistenceException pe) {
					if (!forGUI) throw pe;
				}
			}
			if (RPCConstantsAndServices.test) {
				if (result != null) 
					System.out.println("Show: " 
									   + ((HashMap<String,Object>)result.get(RPCConstantsAndServices.createHashtableKey(proxiInformation.getClassId(), proxiInformation.getObjectId()))).get(RPCConstantsAndServices.RPCToStringFieldName)
									   + " --- Number of retrieved objects: "
									   + result.size());
				else System.out.println("Show: " + proxiInfo + " (not available on server!)");
			}
			if (result == null) return createExceptionResult(new PersistenceException(RPCConstantsAndServices.ObjectNotAvailableErrorMessage, RPCConstantsAndServices.ObjectNotAvailableErrorNo));
			this.removeNullEntries(result);
			return createOKResult(result);
		}catch(PersistenceException pe){
			if (RPCConstantsAndServices.test) System.out.println("Show: " + proxiInfo + " (not available on server!)");
			if (!forGUI) return createExceptionResult(pe);
			else return createExceptionResult(new PersistenceException(RPCConstantsAndServices.ObjectNotAvailableErrorMessage, RPCConstantsAndServices.ObjectNotAvailableErrorNo));
		}
	}

	private void authorise(PersistentProxiInterface proxi) throws PersistenceException {
		
	}

	private void removeNullEntries(HashMap<String, Object> table) {
		java.util.Iterator<String> keys = table.keySet().iterator();
		while (keys.hasNext()){
			String current = keys.next();
			if (table.get(current) == null){
				System.out.println("Null entry removed: " + current);
				keys.remove();
			}
		}
	}
	
	protected XmlRpcRequest getRequest(byte[] request, XmlRpcRequestProcessor requestProcessor) throws PersistenceException{
		try {
			
			//remove salt
			int saltLength = CryptoConstants.SaltLength;
			ByteArrayInputStream input = new ByteArrayInputStream(request,saltLength,request.length - saltLength);
			return requestProcessor.processRequest(input);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage(),0);
		} 		
	}
	protected Object invoke(XmlRpcRequest request) throws PersistenceException{
		try {
			String methodName = request.getMethodName();
			Vector<Object> parameters = request.getParameters();
			Class<?>[] argClasses = null;
			Object[] argValues = null;
			if (parameters != null) {
				argClasses = new Class[parameters.size()];
				argValues = new Object[parameters.size()];
				for (int i = 0; i < parameters.size(); i++) {
					argValues[i] = parameters.elementAt(i);
					if (argValues[i] instanceof Integer) {
						argClasses[i] = Integer.TYPE;
					} else if (argValues[i] instanceof Double) {
						argClasses[i] = Double.TYPE;
					} else if (argValues[i] instanceof Boolean) {
						argClasses[i] = Boolean.TYPE;
					} else {
						argClasses[i] = argValues[i].getClass();
					}
				}
			}
			// invoke
			Method method = this.getClass().getMethod(methodName, argClasses);
			if (method.getDeclaringClass() == Object.class) {
				throw new PersistenceException("Invoker can't call methods defined in java.lang.Object",0);
			}
			return method.invoke(this, argValues);
		} catch (Exception e) {
			if (e.getCause() != null) {
				e.getCause().printStackTrace();
			} else {
				e.printStackTrace(); 
			}
			throw new PersistenceException(e.getMessage(),0);
		} 		
	}
	private java.security.SecureRandom random = new java.security.SecureRandom();
	protected byte[] getResponse(Object invokeResult, XmlRpcRequestProcessor requestProcessor, XmlRpcResponseProcessor responseProcessor) throws PersistenceException{
		try {
			byte[] result = responseProcessor.processResponse(invokeResult, requestProcessor.getEncoding());
			int saltLength = CryptoConstants.SaltLength;
			byte[] salt = new byte[saltLength];
			this.random.nextBytes(salt);
			byte[] finalResult = new byte [salt.length + result.length];
			for (int i = 0; i < saltLength; i++)finalResult[i] = salt[i];
			for (int i = saltLength; i < finalResult.length; i++)finalResult[i] = result[i - saltLength];
			
			if (RPCConstantsAndServices.test) System.out.println("Sent: " + finalResult.length/1000 + "," + (finalResult.length % 1000)/100 + " KByte");
			return finalResult;
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage(),0);
		} 		
	}
	public synchronized byte[] execute(byte[] command) throws PersistenceException {
		XmlRpcResponseProcessor responseProcessor = new XmlRpcResponseProcessor();
		XmlRpcRequestProcessor requestProcessor = new XmlRpcRequestProcessor();
		XmlRpcRequest request = this.getRequest(command, requestProcessor);
		Object invokeResult = null;
		if (this.isDown()) {
			invokeResult = createExceptionResult(new PersistenceException("System is down for maintenance" + (this.downTimeUntil.equals("") ? "" : " until " + this.downTimeUntil) + "! Try later again!", 815));
		} else {
			invokeResult = this.invoke(request);
			this.lastUsedDate = new Date();
		}
		return this.getResponse(invokeResult, requestProcessor, responseProcessor);
	}


}