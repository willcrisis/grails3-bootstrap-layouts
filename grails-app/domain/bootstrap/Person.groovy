package bootstrap

class Person {
    String firstName
    String lastName
    String email
    Date dateOfBirth

    static constraints = {
        firstName blank: false
        lastName blank: false
        email nullable: true, email: true
        dateOfBirth nullable: true
    }
}
