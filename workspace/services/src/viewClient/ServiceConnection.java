package viewClient;

import view.*;
import java.net.MalformedURLException;



public class ServiceConnection extends ConnectionMaster {

	public ServiceConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServiceView getServiceView(){
		return (ServiceView)super.getServer();
	}


}
