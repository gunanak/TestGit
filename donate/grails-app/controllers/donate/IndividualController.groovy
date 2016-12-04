package donate
import grails.converters.JSON
class IndividualController {
	static allowedMethods = [index: "GET",submit: "POST"]
    def index() { 
    	render Individual.list() as JSON
    }
    def submit(){
    	def firstname = request.JSON.firstname
    	def lastname = request.JSON.lastname
    	def money = request.JSON.money

    	new Individual (firstname:firstname,lastname:lastname,money:money).save()
    	render "ok"
    }
}
