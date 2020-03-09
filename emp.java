public class emp {

    int id ;
    String name;
    int age;
    String department;
    String designation;
    emp reportingto;

    public emp(int id, String name, int age, String department, String designation, emp reportingto) {// System.out.println("bye");
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.reportingto = reportingto;
    }



    //    public emp(){
//        System.out.println("hi");
//        id = key.id;
//        name = key.name;
//        age = key.age;
//        department = key.department;
//        designation = key.designation;
//        reportingto = key.reportingto;
//    }



//
//    public void printingInEmp(emp key) {
//
//        String temp;
//        if(key.reportingto == null){
//            temp  = "---";
//        }
//        else{
//            temp = key.reportingto.name;
//        }
//
////        System.out.printf("%10s %20s %10s %20s %20s %20s", key.id, key.name, key.age, key.department, key.designation, temp);
//        System.out.printf("%10s %20s %10s %20s %20s %20s", id, name, age, department, designation, temp);
//
//
//    }

    public static void x(){
        int id = 10;
    }
    public void printingInEmp() {

        String temp;
        if(reportingto == null){
            temp  = "---";
        }
        else{
            temp = reportingto.name;
        }
        System.out.printf("%10s %20s %10s %20s %20s %20s", id, name, age, department, designation, temp);
    }
}

