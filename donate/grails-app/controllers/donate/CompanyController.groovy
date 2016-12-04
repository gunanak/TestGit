package donate
import grails.converters.JSON
class CompanyController {
	static allowedMethods = [index: "GET",submit: "POST"]
    def index() { 
    	render Company.list() as JSON
    }
    def submit(){
    	def companyname = request.JSON.companyname
    	def money = request.JSON.money

    	new Company (companyname:companyname , money:money).save()
    	render "ok"
    }
}
