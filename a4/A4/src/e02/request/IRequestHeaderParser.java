package e02.request;

import e02.header.RequestHeader;

public interface IRequestHeaderParser {
	public RequestHeader parse(String txt) throws Exception;  
}
