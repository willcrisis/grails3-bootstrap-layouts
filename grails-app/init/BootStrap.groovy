import scaffolding.Address
import scaffolding.Person

class BootStrap {

    def init = { servletContext ->
        new Person(firstName: 'John', lastName: 'Doe', dateOfBirth: new Date(), email: 'john.doe@company.com', address: new Address(address1: 'Street, Number', address2: 'District', city: 'City', postCode: 'PostCode')).save(flush: true);
    }
    def destroy = {
    }
}
