package donate
import grails.converters.JSON
class TotalmoneysController {
    def index() { 
    	def companyallmoney =  Company.getAll().money.sum()
    	def donateallmoney =  Donate.getAll().money.sum()
    	def individualallmoney = Individual.getAll().money.sum()
    	def totalmoney = companyallmoney+donateallmoney+individualallmoney;
    	def total = [:]
    	total = [total:totalmoney,alumna:donateallmoney,company:companyallmoney,individual:individualallmoney];
    	render total as JSON
    }
}
