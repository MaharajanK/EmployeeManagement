import java.util.ArrayList;
import java.util.HashMap;

class manager extends employeeManagement {

    private static HashMap<String, Integer> summary_hash_map = new HashMap<String,Integer>();
    private static HashMap<String, Integer> summary_hash_map1 = new HashMap<String,Integer>();
    private static HashMap<String, Integer> summary_hash_map2 = new HashMap<String, Integer>();
//    public manager(int id, String name, int age, String department, String designation, String reportngto) {
//        super(id, name, age, department, designation, reportngto);
//    }

    public manager(int givenId, String givenName) {

        super();

        System.out.println("kkk");

        boolean check = true;
        System.out.println(givenName);

        for(emp value : hash_map.values()){
            System.out.println(value.name);
            if(value.name.equals(givenName) && value.id  == givenId){
                check = false;
                UserRole = value.designation;
                features();
            }
        }
        if(check){
            System.out.println("Enter valid Name and Id");
        }

    }

    public manager() {
        Summary_report();
    }


    public static void Summary_report(){

            for(emp key :hash_map.values()) {

                if(summary_hash_map.containsKey(key.department)){
                    summary_hash_map.replace(key.department,  summary_hash_map.get(key.department), summary_hash_map.get(key.department)+1);

                }
                else{
                    summary_hash_map.put(key.department, 1);
                }

                if(summary_hash_map1.containsKey(key.designation)){
                    summary_hash_map1.replace(key.designation,  summary_hash_map1.get(key.designation), summary_hash_map1.get(key.designation)+1);
                }
                else{
                    summary_hash_map1.put(key.designation, 1);
                }

                System.out.println(key.reportingto);

                if(key.reportingto != null) {
                    if(summary_hash_map2.containsKey(key.reportingto.name)){

                        summary_hash_map2.replace(key.reportingto.name, summary_hash_map2.get(key.reportingto.name), summary_hash_map2.get(key.reportingto.name) + 1);
                    }
                    else{

                        summary_hash_map2.put(key.reportingto.name, 1);

                    }
                }
                else{
                    summary_hash_map2.put("Sriram", 0);
                }

            }
            //System.out.println("**********Department and Employee count**********");
            System.out.println("--------------------------------------------------");
            System.out.printf("%20s %20s","Department","Count");
            System.out.println(" ");
            System.out.println("--------------------------------------------------");
            for(String key :summary_hash_map.keySet()){
                System.out.printf("%20s %20s",key,summary_hash_map.get(key));
                System.out.println("");
            }
            System.out.println("");

//        System.out.println("**********Designation and Employee count**********");
            System.out.println("--------------------------------------------------");
            System.out.printf("%20s %20s","Designation","Count");
            System.out.println(" ");
            System.out.println("--------------------------------------------------");
            for(String key :summary_hash_map1.keySet()){
                System.out.printf("%20s %20s",key,summary_hash_map1.get(key));
                System.out.println("");
                //System.out.println(key+"------->"+summary_hash_map1.get(key));
            }
            System.out.println("");
//        System.out.println("**********Manager and Employee count**********");
            System.out.println("--------------------------------------------------");
            System.out.printf("%20s %20s","Manager","Count");
            System.out.println(" ");
            System.out.println("--------------------------------------------------");
            // System.out.println(summary_hash_map2);
            for(String key :summary_hash_map2.keySet()){
                if(!key.equals(" ")){
                    System.out.printf("%20s %20s",key,summary_hash_map2.get(key));
                    System.out.println("");
                    // System.out.println(key+"------->"+summary_hash_map2.get(key));
                }

            }

            System.out.println("");

            System.out.println("Press ( 9 ) to escape and get more options");
            int returnToManiPage = scan.nextInt();
            if(returnToManiPage == 9){
                features();
            }


    }
}


