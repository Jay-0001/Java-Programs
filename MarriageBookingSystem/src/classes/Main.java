package classes;

import exceptionsn.ApplicantNotFound;

public class Main {
    public static void main(String[] args) {
        Applicant apc1 = new Applicant(101, "Apc1", 25, "Male", null);
        Applicant apc2 = new Applicant(102, "Apc2", 24, "Female", null);
        Applicant apc3 = new Applicant(103, "Apc3", 26, "Male", null);
        Applicant apc4 = new Applicant(104, "Apc4", 28, "Female", null);
        Applicant apc5 = new Applicant(105, "Apc5", 27, "Female", null);
        Applicant apc6 = new Applicant(106, "Apc6", 23, "Male", null);

        //System.out.println(apc2.toString());
        MarriageBookingSystem mb = new MarriageBookingSystem();

        mb.addApplicant(apc1);
        mb.addApplicant(apc2);
        mb.addApplicant(apc3);
        mb.addApplicant(apc4);
        mb.addApplicant(apc5);
        mb.addApplicant(apc6);

        System.out.println(mb);
        try {
            System.out.println(mb.findMatch(apc2));
        } catch (ApplicantNotFound anf) {
            System.out.println(anf.getMessage());
        }
        System.out.println("Unmarried "+mb.findApplicantSummary());
        mb.assignApplicant(101,apc2);
        mb.assignApplicant(102,apc1);
        mb.assignApplicant(103,apc4);
        mb.assignApplicant(104,apc3);
        System.out.println("Unmarried "+mb.findApplicantSummary());
        System.out.println(mb);
        mb.dropProposal(101);
        mb.dropProposal(102);
        System.out.println("Unmarried "+mb.findApplicantSummary());
        System.out.println(mb);


    }
}