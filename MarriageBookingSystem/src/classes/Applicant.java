package classes;

public class Applicant extends Person{
    Person partner;

    public Applicant() {
    }
    public Applicant(int applicationId, String name, int age, String sex, Person partner) {
        super(applicationId, name, age, sex);
        this.partner = partner;
    }

    @Override
    public String toString() {
        if(partner!=null)
            return "Applicant{"+super.toString()+",Partner = "+partner.getApplicationId()+"}";
        else
            return "Applicant{"+super.toString()+",Partner = null}";
    }
}
