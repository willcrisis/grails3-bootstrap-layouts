package scaffolding

class Person {
    String firstName
    String lastName
    String email
    Date dateOfBirth
    Address address

    static embedded = ["address"]

    static constraints = {
        firstName blank: false
        lastName blank: false
        email nullable: true, email: true
        dateOfBirth nullable: true
        address nullable: true
    }
}
