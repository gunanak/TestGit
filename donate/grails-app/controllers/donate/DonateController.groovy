package donate
import grails.converters.JSON
class DonateController {
	static allowedMethods = [index: "GET",submit: "POST"]
    def index() { 
    	render Donate.list() as JSON
    }
    def submit(){
    	def firstname = request.JSON.firstname
    	def lastname = request.JSON.lastname
    	def generation = request.JSON.generation
    	def money = request.JSON.money
        def data = [:]

    	new Donate (firstname:firstname ,lastname:lastname  , generation:generation, money:money).save()
    	def money1 =  Donate.findAllByGeneration(generation).money.sum()
    	def money2 = Moneyupdate.find { generation == generation}
    	if(money2==null){
    		new Moneyupdate (generation:generation,money:money1).save()
    	}
    	else{
    		money2.money = money1
    		money2.save()
    	}
        data = [status: true]
    	render data as JSON
    }
    def updatemoney(){
    	render Moneyupdate.list() as JSON
    }
    def sortbymoney(){
        def c = Moneyupdate.createCriteria().list{
        maxResults(10)
        order("money", "desc")
        }
        render c as JSON

    }
    def sortbygen(){
        def c = Moneyupdate.createCriteria().list{
        maxResults(10)
        order("money", "desc")
        }
        def a = c.sort{(it.generation)};
        render a as JSON
    }
}
