import javax.swing.plaf.synth.SynthLookAndFeel;
import java.net.IDN;
import java.util.*;

public class employeeManagement {
    static HashMap<Integer, emp> hash_map = new HashMap<Integer, emp>();
    static HashMap<Integer, emp> filter_hash_map = new HashMap<Integer, emp>();
    static HashMap<Integer, emp> filter_hash_map2 = new HashMap<Integer, emp>();
    static  String f;
    static int q;
//    static HashMap<String, Integer> summary_hash_map = new HashMap<String,Integer>();
//    static HashMap<String, Integer> summary_hash_map1 = new HashMap<String,Integer>();
//    static HashMap<String, Integer> summary_hash_map2 = new HashMap<String, Integer>();
    static ArrayList<emp> tree = new ArrayList<emp>();
    static ArrayList<Integer> tem = new ArrayList<Integer>();
    static Scanner scan = new Scanner(System.in);
    static  String[] data = {"name"};
    static int employee_count =0;
    static boolean s = true;
    public static String UserRole;

    //public static String UserNmae;
    // public static int UserId;

    public employeeManagement(int id, String name, int age, String department, String designation, String reportngto) {



    }

    public employeeManagement() {

      /*-----------------------------------------------------------------Putting data on hash map----------------------------------------------------------------------*/

        emp obj1 = new emp(1,"Sriram",45,"Management","CEO",null);
        emp obj2 = new emp(2,"Mukund",42,"HR","MR Manager",obj1);
        emp obj12 = new emp(12,"Sriram",46,"HR","Finance Manager",obj2);
        emp obj3 = new emp(3,"Sebastian",38,"Finance","Finance Manager",obj1);
        emp obj4 = new emp(4,"Aashritha",32,"ProductManagement","Dev Manager",obj1);
        emp obj5 = new emp(5,"MohammadRafi",35,"HR","HR Lead",obj2);
        emp obj6 = new emp(6,"AnjaliKumar",29,"HR","HR Lead",obj5);
        emp obj7 = new emp(7,"Joseph",40,"Finance","Finance Associate",obj3);
        emp obj8 = new emp(8,"Ramachandran",27,"ProductDevelopment","Tech Lead",obj4);
        emp obj9 = new emp(9,"AbhinayaShankar",23,"ProductDevelopment","System Development",obj8);
        emp obj10 = new emp(10,"ImranKhan",28,"ProductTesting","QA Lead",obj8);
        emp obj11 = new emp(11,"Mukund",40,"HR","MR Manager",obj12);


        emp[] objs = {obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9,obj10,obj11,obj12};

        for(int i = 0; i < objs.length; i+=1){

            hash_map.put(objs[i].id,objs[i]);
        }

       // features();

        /*-----------------------------------------------------------------Putting data on hash map----------------------------------------------------------------------*/

//
//        boolean check = true;
//        System.out.println(givenName);
//
//         for(emp value : hash_map.values()){
//             System.out.println(value.name);
//             if(value.name.equals(givenName) && value.id  == givenId){
//                 check = false;
//                 UserRole = value.designation;
//                      features();
//             }
//         }
//         if(check){
//             System.out.println("Enter valid Name and Id");
//         }

    }

    public static void inserting_Data(HashMap<Integer, emp> objs){

        System.out.printf("%10s","---------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.printf("%10s %20s %10s %20s %20s %20s", "ID","NMAE","AGE","DEPARTMENT","DESIGNATION","REPORTING TO");
        System.out.println(" ");
        System.out.printf("%10s","---------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        for(emp key :hash_map.values()) {
           // if(!key.name.equals("Sriram")){
                printing(key);
           // }

        }

        System.out.println("----------------------");
        System.out.print("|");
        System.out.print("  EDIT to press : 7 ");
        System.out.print("|");
        System.out.println("");
        System.out.println("----------------------");

        System.out.println("Press ( 9 ) to escape and get more options");
        int returnToManiPage = scan.nextInt();
        if(returnToManiPage == 9){
            features();
        }
        else if(returnToManiPage == 7){
            System.out.println("Are you edit only your NAME press : 0");
            System.out.println("Are you edit only your AGE press : 1");
            System.out.println("Are you edit your NAME and AGE press : 2");
            int edit = scan.nextInt();
            editer(edit);
        }


    }
    public static void editer(int edit){
        if(edit == 0){
            System.out.printf("Enter the CURRENT name : ");
            String currentName = scan.next();
            System.out.printf("Enter the ID no : ");
            int IDNumber = scan.nextInt();
            System.out.printf("Enter the RE ENTER name : ");
            String reEnterName = scan.next();
            for(emp value :hash_map.values()) {
                if(value.name.equals(currentName) && value.id == IDNumber){
                    value.name = reEnterName;
                    inserting_Data(hash_map);
                }
            }
        }
        else if(edit == 1){
            System.out.printf("Enter the CURRENT name : ");
            String currentName = scan.next();
            System.out.printf("Enter the ID no : ");
            int IDNumber = scan.nextInt();
            System.out.printf("Enter the RE ENTER age : ");
            int reEnterAge = scan.nextInt();
            for(emp value :hash_map.values()) {
                if(value.name.equals(currentName) && value.id == IDNumber){
                    value.age = reEnterAge;
                    inserting_Data(hash_map);
                }
            }
        }
        else if(edit == 2){
            System.out.printf("Enter the CURRENT name : ");
            String currentName = scan.next();
            System.out.printf("Enter the ID no : ");
            int IDNumber = scan.nextInt();
            System.out.printf("Enter the RE ENTER name : ");
            String reEnterName = scan.next();
            System.out.printf("Enter the RE ENTER age : ");
            int reEnterAge = scan.nextInt();
            for(emp value :hash_map.values()) {
                if(value.name.equals(currentName) && value.id == IDNumber){
                    value.age = reEnterAge;
                    value.name = reEnterName;
                    inserting_Data(hash_map);
                }
            }
        }

//        for(emp value :hash_map.values()){
//            if(value.name.equals(currentName)){
//                count++;
//            }
//        }
//        if(count == 1){
//            for(emp value :hash_map.values()) {
//                if(value.name.equals(currentName)){
//                    value.name = reEnterName;
//                }
//            }
//        }

    }

    public static void searching_Data(HashMap<Integer, emp> objs){

        filter_hash_map2 = new HashMap<Integer, emp>(objs);
        if(!objs.equals(hash_map)){
            objs.clear();
        }


        int selections = requestGetter();

        if(selections == 0){
//            searchById(filter_hash_map2);
            searchById(filter_hash_map2,"Id");
        }
        else if(selections == 1){
            //searchByName(filter_hash_map2);
            searchByName(filter_hash_map2,"Name");
        }
        else if(selections == 2){
            //searchByDepartment(filter_hash_map2);
            searchByName(filter_hash_map2,"Dept");
        }

        else if(selections == 3){
            //searchByAge(filter_hash_map2);
            searchById(filter_hash_map2,"Age");
        }

        else if(selections == 4){
            //searchByDesignatione(filter_hash_map2);
            searchByName(filter_hash_map2,"Design");
        }
        else if(selections == 5){
            searchByReportingTo(filter_hash_map2);
            //searchByName(filter_hash_map2,"Report");
        }
        else if(selections == 9){
            features();
        }
        else{
            System.out.print("***** Wrong request *****");
            requestGetter();
        }

    }

    public static int askNumericalfield() {
        System.out.println("choose any one operator");
        System.out.println("------------------------");
        System.out.println("> press 0");
        System.out.println("< press 1");
        System.out.println("= press 2");
        System.out.println("!= press 3");
        System.out.println("------------------------");
        int selection = scan.nextInt();
        return selection;

    }




    public static void returnNumericalfielddata(int q, int selection,int id, emp value) {

        if(selection == 0){
            if(q > id){
                printing(value);
                filter_hash_map.put(value.id,value);
            }
        }
        else if(selection == 1){
            if(q < id){
                printing(value);
                filter_hash_map.put(value.id,value);
            }
        }
        else if(selection == 2){
            if(q == id){
                printing(value);
                filter_hash_map.put(value.id,value);
            }
        }
        else if(selection == 3){
            if(q != id){
                printing(value);
                filter_hash_map.put(value.id,value);
            }
        }
    }

    public static int askNumericalfieldForString(){
        System.out.println("choose any one option");
        System.out.println("------------------------");
        System.out.println("Equals : 0");
        System.out.println("Not Equals : 1");
        System.out.println("contains : 2");
        System.out.println("Not Contains : 3");
        System.out.println("Start With : 4");
        System.out.println("Ends With With : 5");
        System.out.println("------------------------");
        int selection = scan.nextInt();
        return selection;
    }


    private static void returnNumericalfielddataForString(String f, int selection, String name, emp value) {
        if(selection == 0){
            if(f.equals(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 1){
            if(!f.equals(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 2){

            if(f.contains(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 3){
            if(!f.contains(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 4){

            if(f.startsWith(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 5){
            if(f.endsWith(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }

    }

    public static void printing(emp key){
        String temp;
        if(key.reportingto == null){
             temp  = "---";
        }
        else{
             temp = key.reportingto.name;
        }

//        emp print = new emp(key);
//        print.printingInEmp();

//        if(key.equals(print)){System.out.println("true");}  //<.................TEST CODE FOR SENDING OBJECT..........................>
//        else {System.out.println("false");}
//        if(key.equals(key)){System.out.println("true");}
//        key.printingInEmp(print);

        key.printingInEmp();

        //System.out.printf("%10s %20s %10s %20s %20s %20s", key.id, key.name, key.age, key.department, key.designation, temp);
        System.out.println(" ");


//        System.out.println("jjjjjjjjjjjjjjjj");
//        print.printing(key);

    }

    public static void searchById(HashMap<Integer, emp> objs,String str){

        System.out.println("Enter "+str+" : ");
        int id = scan.nextInt();
        int selection = askNumericalfield();

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for(emp value :objs.values()) {
            q = fieldFinderForInt(value,str);
            returnNumericalfielddata(q,selection,id,value);
//            if(q == id){
//                printing(value);
//                filter_hash_map.put(value.id,value);
//            }

        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        if(filter_hash_map.size() == 0){
            System.out.println("............DATA NOT MATCHED...............");
        }
        else{
            searching_Data(filter_hash_map);
        }



    }

    public static void searchByReportingTo(HashMap<Integer, emp> objs){

        System.out.println("Enter Manager : ");
        String name = scan.next();

        int selection = askNumericalfieldForString();//number vanga .........

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for(emp value :objs.values()) {

            if(value.reportingto != null){
                returnNumericalfielddataForReportingTo(selection, value.reportingto.name, name, value);

            }


        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        if(filter_hash_map.size() == 0){
            System.out.println("............DATA NOT MATCHED...............");
        }
        else{
            System.out.println(filter_hash_map.size());
            searching_Data(filter_hash_map);
        }
    }
    public static void  returnNumericalfielddataForReportingTo(int selection,String f,String name, emp value){

        if(selection == 0){
            if(f.equals(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 1){
            if(!f.equals(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 2){

            if(f.contains(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 3){
            if(!f.contains(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 4){

            if(f.startsWith(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
        else if(selection == 5){
            if(f.endsWith(name)){
                printing(value);
                filter_hash_map.put(value.id,value);
                // tem.add(value.id);
            }
        }
    }
    public static void searchByName(HashMap<Integer, emp> objs,String str){

        System.out.println("Enter "+str+" : ");
        String name = scan.next();

        int selection = askNumericalfieldForString();

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for(emp value :objs.values()) {
            f = fieldFinderForString(value,str);
            returnNumericalfielddataForString(f,selection,name,value);

        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        if(filter_hash_map.size() == 0){
            System.out.println("............DATA NOT MATCHED...............");
        }
        else{
            searching_Data(filter_hash_map);
        }

//        System.out.println("Enter name : ");
//        String name = scan.next();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        for(emp value :objs.values()) {
//            if(value.name.equals(name)){
//                printing(value);
//                filter_hash_map.put(value.id,value);
//                tem.add(value.id);
//               // System.out.println(filter_hash_map.size()+"..........");
//            }
//
//        }
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        if(filter_hash_map.size() == 0){
//            System.out.println("............DATA NOT MATCHED...............");
//        }
//        else{
//            searching_Data(filter_hash_map);
//        }


    }



    private static int fieldFinderForInt(emp value,String str) {
        if(str.equals("Id")){
            q = value.id;
        }
        else if(str.equals("Age")){
            q = value.age;
        }
        return q;
    }
    private static String fieldFinderForString(emp value,String str) {
        if(str.equals("Name")){
            f = value.name;
        }
        else if(str.equals("Dept")){
            f = value.department;
        }
        else if(str.equals("Design")){
            f = value.designation;
        }
        else if(str.equals("Report")){
            emp t = value.reportingto;
            //f = t.reportingto;
        }
        return f;
    }

//    public static void searchByDepartment(HashMap<Integer, emp> objs){
//
//        System.out.println("Enter department_name : ");
//        String dept = scan.next();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        for(emp value :objs.values()) {
//            if(value.department.equals(dept)){
//
//                printing(value);
//                filter_hash_map.put(value.id,value);
//                //System.out.println(filter_hash_map.size()+"..........");
//            }
//
//        }
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        if(filter_hash_map.size() == 0){
//            System.out.println("............DATA NOT MATCHED...............");
//        }
//        else{
//            searching_Data(filter_hash_map);
//        }
//
//    }
//    public static void searchByAge(HashMap<Integer, emp> objs){
//
//        System.out.println("Enter age : ");
//        int age = scan.nextInt();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        for(emp value :objs.values()) {
//            if(value.age == age){
//
//                printing(value);
//                filter_hash_map.put(value.id,value);
//                //System.out.println(filter_hash_map.size()+"..........");
//            }
//
//        }
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        if(filter_hash_map.size() == 0){
//            System.out.println("............DATA NOT MATCHED...............");
//        }
//        else{
//            searching_Data(filter_hash_map);
//        }
//    }
//    public static void searchByDesignatione(HashMap<Integer, emp> objs){
//
//        System.out.println("Enter Designatione : ");
//        String Designation = scan.next();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        for(emp value :objs.values()) {
//            if(value.designation.equals(Designation)){
//
//                printing(value);
//                filter_hash_map.put(value.id,value);
//               // System.out.println(filter_hash_map.size()+"..........");
//            }
//
//        }
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        if(filter_hash_map.size() == 0){
//            System.out.println("............DATA NOT MATCHED...............");
//        }
//        else{
//            searching_Data(filter_hash_map);
//        }
//    }


//    public static void searchByReportingTo(HashMap<Integer, emp> objs){
//
//        System.out.println("Enter ManagerName : ");
//        String manager = scan.next();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        for(emp value :objs.values()) {
//            if(value.reportingto.equals(manager) ){
//
//                printing(value);
//                filter_hash_map.put(value.id,value);
//
//            }
//
//        }
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        if(filter_hash_map.size() == 0){
//            System.out.println("............DATA NOT MATCHED...............");
//        }
//        else{
//            searching_Data(filter_hash_map);
//        }
//    }
//    public static void searchByAnotherFilter(){
//        System.out.println("You want another filter say (yes or no)");
//            String request = scan.next();
//            if(request.equals("yes")){
//                int num = requestGetter();
//              //searching_Data(num);..........
//            }
//            else{
//                System.out.println("...........");
//            }
//    }


    public static int requestGetter(){

        System.out.println("if you have id please press : 0");
        System.out.println("if you have name please press : 1");
        System.out.println("if you have department please press : 2");
        System.out.println("if you have age please press : 3");
        System.out.println("if you have Designation please press : 4");
        System.out.println("if you have Manager name please press : 5");
        System.out.println("Press ( 9 ) to escape and get more options");
        int num = scan.nextInt();

        return num;
    }

    public static void employees_under_Manager(HashMap<Integer, emp> objs){
        System.out.println("Enter the Manager name");
        String ManagerName = scan.next();
        System.out.println("----------------------");
        for(emp value :hash_map.values()) {
            System.out.println("hiiiiiiiiiii");
            if(!value.name.equals("Sriram")){
                if(value.reportingto.name.equals(ManagerName)){
                    //printing(
                    System.out.println(value.name);
                }
            }

        }
        System.out.println("----------------------");
        System.out.println("Press ( 9 ) to escape and get more options");
        int returnToManiPage = scan.nextInt();
        if(returnToManiPage == 9){
            features();
        }
    }


//    public static void Summary_report(){
//
//        for(emp key :hash_map.values()) {
//
//            if(summary_hash_map.containsKey(key.department)){
//                summary_hash_map.replace(key.department,  summary_hash_map.get(key.department), summary_hash_map.get(key.department)+1);
//
//            }
//            else{
//                summary_hash_map.put(key.department, 1);
//            }
//
//            if(summary_hash_map1.containsKey(key.designation)){
//                summary_hash_map1.replace(key.designation,  summary_hash_map1.get(key.designation), summary_hash_map1.get(key.designation)+1);
//            }
//            else{
//                summary_hash_map1.put(key.designation, 1);
//            }
//
//            System.out.println(key.reportingto);
//
//            if(key.reportingto != null) {
//               if(summary_hash_map2.containsKey(key.reportingto.name)){
//
//                    summary_hash_map2.replace(key.reportingto.name, summary_hash_map2.get(key.reportingto.name), summary_hash_map2.get(key.reportingto.name) + 1);
//                }
//                else{
//
//                    summary_hash_map2.put(key.reportingto.name, 1);
//
//                }
//            }
//            else{
//                summary_hash_map2.put("Sriram", 0);
//            }
//
//        }
//        //System.out.println("**********Department and Employee count**********");
//        System.out.println("--------------------------------------------------");
//        System.out.printf("%20s %20s","Department","Count");
//        System.out.println(" ");
//        System.out.println("--------------------------------------------------");
//        for(String key :summary_hash_map.keySet()){
//            System.out.printf("%20s %20s",key,summary_hash_map.get(key));
//            System.out.println("");
//        }
//        System.out.println("");
//
////        System.out.println("**********Designation and Employee count**********");
//        System.out.println("--------------------------------------------------");
//        System.out.printf("%20s %20s","Designation","Count");
//        System.out.println(" ");
//        System.out.println("--------------------------------------------------");
//        for(String key :summary_hash_map1.keySet()){
//            System.out.printf("%20s %20s",key,summary_hash_map1.get(key));
//            System.out.println("");
//            //System.out.println(key+"------->"+summary_hash_map1.get(key));
//        }
//        System.out.println("");
////        System.out.println("**********Manager and Employee count**********");
//        System.out.println("--------------------------------------------------");
//        System.out.printf("%20s %20s","Manager","Count");
//        System.out.println(" ");
//        System.out.println("--------------------------------------------------");
//       // System.out.println(summary_hash_map2);
//        for(String key :summary_hash_map2.keySet()){
//            if(!key.equals(" ")){
//                System.out.printf("%20s %20s",key,summary_hash_map2.get(key));
//                System.out.println("");
//                // System.out.println(key+"------->"+summary_hash_map2.get(key));
//            }
//
//        }
//
//        System.out.println("");
//
//        System.out.println("Press ( 9 ) to escape and get more options");
//        int returnToManiPage = scan.nextInt();
//        if(returnToManiPage == 9){
//            features();
//        }
//
//    }

    public static void reportingToTree(HashMap<Integer, emp> objs){

        int i = 1;
        while (i>0) {

            if (tree.get(tree.size() - 1) != null) {
               // System.out.println(tree.get(tree.size() - 1).name);
               // if(!tree.get(tree.size()-1).name.equals("Sriram")){
                   // finder(tree.get(tree.size() - 1));
              //  }
               // else{
                    finder(tree.get(tree.size() - 1));

               // }

            }
            else {
                i=0;
            }
        }
        System.out.println("----------------------------------------");
        for(int j = 0; j < tree.size()-1; j += 1 ){

                System.out.print(tree.get(j).name);


            if(j != tree.size()-2){
                System.out.print("      ----->       ");
            }
        }

        System.out.println();
        System.out.println("----------------------------------------");

        System.out.println("Press ( 9 ) to escape and get more options");
        int returnToManiPage = scan.nextInt();
        if(returnToManiPage == 9){tree.clear();
            features();
        }

    }

    public static void finder(emp name){
         System.out.println(tree.size());
        for(emp value :hash_map.values()) {

            if(value.name.equals(name.name)){

                tree.add(value.reportingto);
                break;
            }

        }

    }



    public static void features(){
        System.out.println("You want to show all employee details enter : 1");
        System.out.println("You search employee details enter : 2");
        System.out.println("You want to show employees name under working particular department : 3");
        System.out.println("You want to show Employee-Tree: 5");
//        System.out.println(UserRole);
        if(UserRole.equals("CEO")){
            System.out.println("You want to show summery: 4");
        }



        int choice = scan.nextInt();

        if(choice == 1){
            inserting_Data(hash_map);
        }
        else if(choice == 2){
            searching_Data(hash_map);
        }
        else if(choice == 3){
            employees_under_Manager(hash_map);
        }

        else if(choice == 5){

            System.out.println("Enter the Employee name : ");
            String emp_name = scan.next();
            System.out.println(emp_name);
            for(emp value : hash_map.values()){

                if(value.name.equals(emp_name)){
                    tree.add(value);
                    break;
                }
            }

            reportingToTree(hash_map);
        }

        else if(choice == 4  && UserRole.equals("CEO")){
             manager man = new manager();
            // man.Summary_report();
        }


        else{
            System.out.println("Please enter correct number");

        }
    }
    public static void main (String[] args){



//        emp obj1 = new emp(1,"Sriram",45,"Management","CEO",null);
//        emp obj2 = new emp(2,"Mukund",42,"HR","MRManager",obj1);
//        emp obj12 = new emp(12,"Sriram",46,"HR","FInanceManager",obj2);
//        emp obj3 = new emp(3,"Sebastian",38,"Finance","FInanceManager",obj1);
//        emp obj4 = new emp(4,"Aashritha",32,"ProductManagement","DevManager",obj1);
//        emp obj5 = new emp(5,"MohammadRafi",35,"HR","HRLead",obj2);
//        emp obj6 = new emp(6,"AnjaliKumar",29,"HR","HRLead",obj5);
//        emp obj7 = new emp(7,"Joseph",40,"Finance","FinanceAssociate",obj3);
//        emp obj8 = new emp(8,"Ramachandran",27,"ProductDevelopment","TechLead",obj4);
//        emp obj9 = new emp(9,"AbhinayaShankar",23,"ProductDevelopment","SystemDevelopment",obj8);
//        emp obj10 = new emp(10,"ImranKhan",28,"ProductTesting","QALead",obj8);
//        emp obj11 = new emp(11,"Mukund",40,"HR","MRManager",obj12);
//
//
//        emp[] objs = {obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9,obj10,obj11,obj12};
//
//        for(int i = 0; i < objs.length; i+=1){
//
//            hash_map.put(objs[i].id,objs[i]);
//        }
//
//        features();




    }
}












//import java.util.HashMap;
//
//public class exercise2 {
//
//    public static void main(String[] args) {
//        HashMap<String, String> orginalMap = new HashMap<String,String>();
//        orginalMap.put("name1","Mahabro");
//        orginalMap.put("name2","raja");
//        orginalMap.put("name3","jnaki");
//        //System.out.println(orginalMap.get("name"));
//
//        HashMap<String, String> copyMap = new HashMap<String,String>(orginalMap);
//        //System.out.println(copyMap.get("name"));
//
//        //orginalMap.put("name","Anand");
//        orginalMap.clear();
//
//        System.out.println(orginalMap.size());
//        System.out.println(copyMap.size());
//
//        System.out.println(orginalMap.get("name"));
//        System.out.println(copyMap.get("name"));
//    }
//}
