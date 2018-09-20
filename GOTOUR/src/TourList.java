import java.util.Iterator;

public class TourList implements Iterable<TouristAttraction> {
	TourList tourList;

	private GenericList<TouristAttraction> taList = new GenericList<>();
	
	 @Override
	    public Iterator<TouristAttraction> iterator() {
	        return taList.iterator();
	    }
	
	 
	// Adds a single tourist attraction (TA) to system.
	public void addTA (String name, String estb, String dscrip, String location, String coe) {
		
		TouristAttraction newTA = new TouristAttraction(name, estb, dscrip, location, coe);
		taList.addNode(newTA);
		System.out.println("Tourist Attraction successfully added: " + newTA.toString());
	}
	
	//Find movie using the movie title.
	public TouristAttraction findTAByName(String name) {
        for(TouristAttraction TA : this){
            if (TA.getName().equals(name)){
                return TA;
            }
        }
        System.out.println(name + " not found.");
        return null;
    } 
	
	// Remove a single Tourist Attraction from system. Use TA title to decide on the TA to be deleted.
	public void removeTAByName(String name){
        // checks if TA exists
        TouristAttraction removeThisTA = findTAByName(name);
        // if it exists, it is removed.
        if (removeThisTA != null){

            taList.removeNode(removeThisTA);
            System.out.println(name + " has been removed");
        }
    }
	
	public boolean isEmpty(){
        if (taList.isEmpty()){
            System.out.println("There are no Tourist Attractions in the system.");
        }
        return taList.isEmpty();
    }

	
	// Getter
	public TourList getTourList() {
		return null;
	}
}
