import javax.swing.*;


public class PetCareApplication {

	public static void main(String[] args) {
		
		prt("Welcome to the Kroll Pet Care Admin Panel.", 0);
		prt("Please enter your Username and Password to Log In.", 1);
		/**
		 * Create chain owner object
		 */
		ChainOwner chainOwner = new ChainOwner();
		
		/**
		 * Create performance report object
		 */
		Report performance = new StorePerformanceReport();
		
		/**
		 * Create member report object
		 */
		// TODO Depends on MemberReport Class
		//Report member = new MemberReport();
		
		/**
		 * Display Administration Menu
		 */
		displayAdministrationMenu();
		
		/**
		 * Generate performance report
		 */
		performance.generateReport();
		
		/**
		 * Generate member report
		 */
		// TODO Depends on MemberReport Class
		//member.generateReport();

	}

	/**
	 * Display Administration Menu
	 */
	private static void displayAdministrationMenu() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param prt
	 * @param displayTypeFlag 0 - No Input Fields 1 - Two Input Fields
	 */
	public static void prt(String prt, int displayTypeFlag)
	{
		if(displayTypeFlag==0)
		{
			displayNoIFMessage(prt);
		}
		else if(displayTypeFlag==1)
		{
			displayTwoIFMessage(prt);
		}
	  
	}
	  
	/**
	* validates JOptionPane input
	* 
	* @param variableName
	* @param dataTypeFlag 0 - String type, 1 - int type, 2 - double type
	* @return
	*/
	private static String validateJOptionPane(String variableName, int dataTypeFlag)
	{
	    int variableFlag = 1;
	    String stringToBeObtained = "";
	
	while(variableFlag==1)
	{
	    try
	    {
	        if(variableName.equals("position rank"))
	        {
	            stringToBeObtained = JOptionPane.showInputDialog( 
	                    null, 
	                    "Please choose your position:\n"
	                            + "1. Full Professor\n"
	                            + "2. Associate Professor\n"
	                            + "3. Assitant Professor\n"
	                            + "4. Others\n", 
	                    "Pet Care App",
	                    JOptionPane.QUESTION_MESSAGE
	                    );
	        }
	        else
	        {
	            stringToBeObtained = JOptionPane.showInputDialog( 
	                    null, 
	                    "Please enter your " + variableName + ":\n",
	                    "Pet Care App",
	                    JOptionPane.QUESTION_MESSAGE
	                    );
	        }
	        
	        if(!stringToBeObtained.isEmpty() && stringToBeObtained!=null)
	        {
	            if(dataTypeFlag==1)
	            {
	                int intToBeObtained = Integer.parseInt(stringToBeObtained);
	                stringToBeObtained = String.valueOf(intToBeObtained); 
	            }
	            else if(dataTypeFlag==2)
	            {
	                double doubleToBeObtained = Double.parseDouble(stringToBeObtained);
	                stringToBeObtained = String.valueOf(doubleToBeObtained);
	            }
	            variableFlag=0;
	        }
	        else
	            JOptionPane.showMessageDialog( 
	                    null, 
	                    "Sorry! The " + variableName +" was invalid. Please enter it again.\n",
	                    "Pet Care App",
	                    JOptionPane.ERROR_MESSAGE
	                );
	        
	    }
	    catch(NumberFormatException e)
	    {
	        JOptionPane.showMessageDialog( 
	                null, 
	                "Sorry! Numeric values only.\n",
	                "Pet Care App",
	                    JOptionPane.ERROR_MESSAGE
	            );
	        }
	    }
	    
	    return stringToBeObtained;
	}
	
	/**
	 * 
	 * @param message
	 */
	public static void displayNoIFMessage(String message)
	{
	    JOptionPane.showMessageDialog(null, 
	            message,
	            "Pet Care App",
	            JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 * @param message
	 */
	public static void displayTwoIFMessage(String message)
	{
		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] field = {
		    "Username:", username,
		    "Password:", password
		};

		int option = JOptionPane.showConfirmDialog(null, field, message, JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
		    if (username.getText().equals("h") && password.getText().equals("h")) {
		        System.out.println("Login successful");
		    } else {
		        System.out.println("login failed");
		    }
		} else {
		    System.out.println("Login canceled");
		}
	}

}