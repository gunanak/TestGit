package donate

class Donate {
	String firstname
	String lastname
	Integer generation
	Double money
    static constraints = {
    	firstname nullable: true
    	lastname nullable: true

    }
}
