package locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
private static ServiceLocator instance;
private Map<String, Object>cache;
private Context ctx;
	private ServiceLocator() {
		cache= new HashMap<String,Object>();
		try {
			ctx=new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * singleton design pattern
	 * @return
	 */
	public static ServiceLocator getInstance(){
	if(instance == null)
		instance=new ServiceLocator();
	return instance;
		
	}
	public synchronized Object getProxy(String jndi){
		Object proxy=null;
		if(cache.get(jndi)!=null){
			return cache.get(jndi);
		}
		else {
			try {
				proxy = ctx.lookup(jndi);
				if(proxy!=null){
					cache.put(jndi, proxy);
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return proxy;
	}

}
