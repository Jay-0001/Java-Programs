package classes;
import exceptionsn.ApplicantNotFound;

import java.util.*;

public class MarriageBookingSystem {
    ArrayList<Applicant> mbs = new ArrayList<>();
    boolean addApplicant(Applicant a){
        for(Applicant b : mbs){
            if(b.getApplicationId()==a.getApplicationId())
                return false;
        }
        mbs.add(a);
        return true;
    }
    List<Applicant> findMatch(Applicant a) throws ApplicantNotFound{
        List<Applicant> match = new ArrayList<>();
        for(Applicant b : mbs){
            if(b.getSex()!=a.getSex()&&b.getAge()>=a.getAge())
                match.add(b);
        }
        if(match==null)
            throw new ApplicantNotFound("No match found");
        return match;
    }
    boolean assignApplicant(int applicantId,Applicant a){
        Iterator<Applicant> itr = mbs.iterator();
        Applicant x;
        while(itr.hasNext()){
           x=itr.next();
           if(x.getApplicationId()==applicantId) {
               x.partner = a;
               return true;
           }
        }
        return false;
    }
    boolean dropProposal(int applicantId){
        for(Applicant x : mbs){
            if(x.getApplicationId()==applicantId){
                x.partner=null;
                return true;
            }
        }
        return false;
    }
    Map<String,Integer> findApplicantSummary(){
        Map<String,Integer> summary = new HashMap<>();
        summary.put("Male",0);
        summary.put("Female",0);
        for(Applicant x : mbs){
            if(x.partner==null){
                summary.put(x.getSex(),summary.get(x.getSex())+1);
            }
        }
        return summary;
    }

    @Override
    public String toString() {
        return "MarriageBookingSystem{" +
                "mbs=" + mbs +
                '}';
    }
}
