package donate

class Individual {
	String firstname
	String lastname
	Double money
    static constraints = {
    	firstname nullable: true
    	lastname nullable: true
    }
}
