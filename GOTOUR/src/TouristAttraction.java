public class TouristAttraction {
	private String name;
	private String established;
	private String description;
	private String location;
	private String coe;
	
	
	
	TourList tourList = new TourList();
	
	
	//constructor
		public TouristAttraction(String name, String estb, String dscrip, String location, String coe){
			this.name = name;
			this.established = estb; 
	        this.description = dscrip;
	        this.location = location;	
	        this.coe = coe;
		}
			
	 
	@Override
	public String toString() 
	{
	    return "\n Name: " + name + ". \n Date Established  : " + established  +  ". \n  Venue Description: " + description + ". \n Venue location: " +  location + ". \n Cost of Entry: " + coe;
	}
	
	  
	// Getter and Setters
	public String getName() {
		return name;
	}

}
