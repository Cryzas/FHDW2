package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class RegisterConnection extends ServiceConnection {

	public RegisterConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public RegisterView getRegisterView(){
		return (RegisterView)super.getServer();
	}

    public synchronized String register_Menu_Filter(Anything anything) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (anything == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)anything).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "register_Menu_Filter", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return (String)success.get(common.RPCConstantsAndServices.ResultFieldName);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void register(String accountName, String password) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(accountName);
            parameters.add(password);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "register", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
