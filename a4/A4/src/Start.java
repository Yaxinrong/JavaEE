
public class Start {
	public static void main(String[] args) {  
        try {  
        	System.out.println("Serving...");;
            Server.openServer();  
        } catch (Exception e) {  
        	e.printStackTrace();
            try {
            	Server.closeServer();  
            } catch (Exception e1) {  
                e1.printStackTrace(); 
            }  
        }  
    }  
}
