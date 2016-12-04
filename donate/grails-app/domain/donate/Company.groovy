package donate

class Company {
	String companyname
	Double money
    static constraints = {
    	companyname nullable: true
    }
}
