package gkhts.payment.model;

public class ProviderConnectionConfigurer {

	private String host;
	private Integer port;
	private String path;
	public ProviderConnectionConfigurer(String host,Integer port,String path){

		this.host = host;
		this.port = port;
		this.path = path;
		
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
