import java.util.*;
import java.io.*;

class AppointmentBooking {
	List<String> doctorName = new ArrayList<String>();
    List<Integer> doctorAge = new ArrayList<Integer>();
    List<Long> doctorPhNo = new ArrayList<Long>();
    List<Object> doctorPasssword = new ArrayList<Object>();
    List<String> doctorQualifications = new ArrayList<String>();
    List<String> doctorCity = new ArrayList<String>();
    List<String> doctorGender = new ArrayList<String>();

    ArrayList<String> patientName = new ArrayList<String>();
    ArrayList<Integer> patientAge = new ArrayList<Integer>();
    ArrayList<Long> patientPhNo = new ArrayList<Long>();
    ArrayList<Object> patientPasssword = new ArrayList<Object>();
    ArrayList<Object> patientConfirmPasswordd = new ArrayList<Object>();
    ArrayList<String> patientGender = new ArrayList<String>();

    ArrayList<String> patientBookingName = new ArrayList<String>();
    ArrayList<Integer> patientBookingAge = new ArrayList<Integer>();
    ArrayList<String> patientBookingGender = new ArrayList<String>();
    ArrayList<Byte> doctorID = new ArrayList<Byte>();

    void dataAdd() {
        doctorName = Arrays.asList("Faizan khan", "MD Mobeen", "Zunnurain chaush", "MD Shakil", "MD Atif", "Kaif khan");
        doctorAge = Arrays.asList(22, 23, 22, 23, 25, 26);
        doctorQualifications = Arrays.asList("MBBS,MD", "MBBS", "Er,MBBS", "BAMS", "MBBS", "BAMS,MBBS");
        doctorPhNo = Arrays.asList(6363636363l, 2323232323l, 5656565656l, 8989898989l, 5656565658l, 8587858745l);
        doctorCity = Arrays.asList("Ranchi", "Bisfi", "Nanded", "Siwan", "Mau", "Azamgarh");
        doctorGender = Arrays.asList("Male", "Male", "Male", "Male", "Male", "Male");
        doctorPasssword = Arrays.asList("123", "234", "345", "456", "567", "678");

    }

    void admin() throws Exception {
        Scanner scan = new Scanner(System.in);
        byte choice;
        boolean flag = true;

        while (flag) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\t\t ________________________");
            System.out.println("\t\t|                        |");
            System.out.println("\t\t|     WELCOME ADMIN      |");
            System.out.println("\t\t|________________________|");
            System.out.println(
                    "\n\n1.Doctor list \t2.Registered Patient \t3.Patient with appointment \t4.Main menu \n\n Enter Your Choice:");
            choice = scan.nextByte();
            switch (choice) {
                case 1:
                    for (String name : doctorName) {
                        System.out.println("Name : \t" + name);
                    }
                    byte menuChoice;
                    System.out.println("\n1.Main menu \t2.Previous menu");
                    menuChoice = scan.nextByte();
                    if (menuChoice == 1) {
                        flag = false;
                    } else {
                        break;
                    }
                    break;

                case 2:
                    if (patientName.isEmpty()) {
                        System.out.println("No Registered Patient");
                        Thread.sleep(3000);
                        break;
                    } else {
                        for (String name : patientName) {
                            System.out.println("Name :\t" + name);
                        }

                        System.out.println("\n1.Main menu \t2.Previous menu");
                        menuChoice = scan.nextByte();
                        if (menuChoice == 1) {
                            flag = false;
                        } else {
                            break;
                        }
                        break;
                    }

                case 3:
                    if (patientBookingName.isEmpty()) {
                        System.out.println("No Appointment");
                        Thread.sleep(3000);
                        break;
                    } else {
                        for (String name : patientBookingName) {
                            System.out.println("Name :\t" + name);
                        }
                        Thread.sleep(5000);
                    }
                    break;

                case 4:
                    if (choice == 4) {
                        flag = false;
                    }
                    break;

                default:
                    System.out.println("Wrong choice!!!! Please enter the right value");
                    Thread.sleep(1000);
                    flag = true;

            }
        }
    }

    void patient() throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\t\t _______________________________");
            System.out.println("\t\t|                               |");
            System.out.println("\t\t|     WELCOME PATIENT PAGE      |");
            System.out.println("\t\t|_______________________________|");
            System.out.println("\n\n1.Login \t2.Registration");
            byte choice;
            choice = scan.nextByte();
            switch (choice) {
                case 1:
                    if (patientPhNo.isEmpty()) {
                        System.out.println("No Registered patient");
                        Thread.sleep(3000);
                        break;
                    } else {
                        patientLogin();
                        flag = false;
                    }
                    break;
                case 2:
                    patientRegistration();
                    flag = false;
                    break;

                default:
                    System.out.println("Wrong Choice");
                    Thread.sleep(1000);
                    break;
            }

        }
    }

    void doctor() throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\t\t _______________________________");
            System.out.println("\t\t|                               |");
            System.out.println("\t\t|      WELCOME DOCTOR PAGE      |");
            System.out.println("\t\t|_______________________________|");
            System.out.println("\n\n1.Login \t2.Registration");
            byte choice;
            choice = scan.nextByte();
            switch (choice) {
                case 1:
                    if (doctorPhNo.isEmpty()) {
                        System.out.println("\n First Register");
                        Thread.sleep(2000);
                        break;
                    } else {
                        doctorLogin();
                        break;
                    }
                    // break;
                case 2:
                    doctorRegistration();
                    flag = false;
                    break;

                default:
                    System.out.println("Wrong Input");
                    Thread.sleep(2000);
                    break;
            }
        }

    }

    void patientLogin() throws Exception {
        Scanner scan = new Scanner(System.in);
        long phNo;
        Object password;
        Byte choice;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\t\t _________________________");
        System.out.println("\t\t|                         |");
        System.out.println("\t\t|          Login          |");
        System.out.println("\t\t|_________________________|");
        System.out.println("Enter the username(mobile No)");
        phNo = scan.nextLong();
        password = scan.next();

        boolean flag1 = false,flag = true;
        int i;
        for (i = 0; i <= patientPhNo.size() - 1; i++) {
            if ((patientPhNo.get(i)).equals(phNo) && (patientPasssword.get(i)).equals(password)) {
                flag1 = true;
                break;
            } else {
                System.out.println("Wrong Credentials");
                Thread.sleep(3000);
                break;
            }
        }
        if (flag1 == true) {
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\t\t _________________________________");
            System.out.println("\t\t|                                 |");
            System.out.println("\t\t|        BOOK APPOINTMENT         |");
            System.out.println("\t\t|_________________________________|");
            System.out.println("\n Welcome " + patientName.get(i) + ",to book apointment, chose your doctor...");

            for (int j = 0; j <= doctorName.size() - 1; j++) {
                System.out.println((j + 1) + ". " + doctorName.get(j));
            }
            choice = scan.nextByte();
            doctorID.add(choice);

            while (flag) {
                Thread.sleep(1000);

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("\t\t  _________________________");
                System.out.println("\t\t |                         |");
                System.out.println("\t\t |     Book Appointment    |");
                System.out.println("\t\t |_________________________|");

                if (choice <= doctorName.size() && choice > 0) {
                    System.out.println("\n Doctor name : \t" + doctorName.get(choice = 1) + "\n Doctor age : \t"
                            + doctorAge.get(choice = 1) + "\n Doctor city : \t" + doctorCity.get(choice - 1));
                    System.out.println("Enter your name : ");
                    patientBookingName.add(scan.next());
                    System.out.println("Enter your age : ");
                    patientBookingAge.add(scan.nextInt());
                    System.out.println("Enter your Gender");
                    patientBookingGender.add(scan.next());
                    System.out.println("\n Booking successfull");
                    flag = false;
                    break;
                } else {
                    System.out.println("Wrong input");
                    flag = false;
                    Thread.sleep(2000);
                }
            }
        } else {
            System.out.println("login Unsucessfull");
            Thread.sleep(1000);
            flag = false;
        }

    }

    void doctorLogin() throws Exception {
        Scanner scan = new Scanner(System.in);
        long mobileNumber;
        String password;
        boolean flag = true;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\t\t  ___________________________________________");
        System.out.println("\t\t |                                           |");
        System.out.println("\t\t |         THIS IS DOCTOR LOGIN PAGE		   |");
        System.out.println("\t\t |___________________________________________|");

        System.out.println("Enter your Username(mobilenumber)");
        mobileNumber = scan.nextLong();
        System.out.println("Enter your Password");
        password = scan.next();
        int i = 0;
        boolean flag1 = true;
        for (i = 0; i <= doctorName.size() - 1; i++) {
            if (doctorPhNo.get(i).equals(mobileNumber) && doctorPasssword.get(i).equals(password)) {
                flag = true;
                break;
            }
        }
        if (flag == true) {
            while (flag1) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("\t\t  ___________________________________________");
                System.out.println("\t\t |                                           |");
                System.out.println("\t\t |         Welcome doctor" + doctorName.get(i) + " |");
                System.out.println("\t\t |___________________________________________|");
                System.out.println("\n\n1.Patient with apppointment \t2.previous menu");

                byte choice;
                byte j = 0;
                choice = scan.nextByte();
                switch (choice) {
                    case 1:
                        if ((doctorID.isEmpty() != true)) {
                            while (j <= doctorID.size() - 1) {
                                if ((i + 1) == doctorID.get(j)) {
                                    System.out.println("patient name: " + patientBookingName.get(j));
                                    j++;

                                }
                            }
                            Thread.sleep(4000);
                        } else {
                            System.out.println("No appointment.....!");
                            Thread.sleep(3000);
                            flag1 = true;
                        }
                        break;
                }

            }

        } 
        else {
            System.out.println("Login Unsuccessful..");
        }
    }

    void patientRegistration()throws Exception {
        Scanner scan = new Scanner(System.in);
        long mobileNumber;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\t\t  ___________________________________________________");
        System.out.println("\t\t |                                                   |");
        System.out.println("\t\t |         THIS IS PATIENT REGISTRATION PAGE		   |");
        System.out.println("\t\t |___________________________________________________|");

        System.out.println("please enter your name");
        patientName.add(scan.next());
        System.out.println("please enter your age...");
        patientAge.add(scan.nextInt());
        System.out.println("please enter your phone number .....");
        mobileNumber = scan.nextLong();
        long mno;

        boolean flag1 = true;
        if(patientPhNo.isEmpty()){
            patientPhNo.add(mobileNumber);
            System.out.println("enter password");
            patientPasssword.add(scan.next());
            System.out.println("registration is successfull");
            Thread.sleep(900);
            flag1=false;
        }
        else{
            for( int i=0;i<=patientPhNo.size()-1;i++){
                mno = patientPhNo.get(i);
                if(mno==mobileNumber){
                    flag1=false;
                    break;
                }
            }if(flag1==true){
                patientPhNo.add(mobileNumber);
                System.out.println("enter password");
                patientPasssword.add(scan.next());
                System.out.println("registration successfull");
                Thread.sleep(1000);
            }
            else{
                System.out.println("same mobile number is not allowed");
                Thread.sleep(500);
            }
        }


    }

    void doctorRegistration()throws Exception {
        Scanner scan = new Scanner(System.in);
        int  i= 0;
        long mobileNumber;
        boolean flag = true , flag1 = true;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\t\t  ___________________________________________________");
        System.out.println("\t\t |                                                   |");
        System.out.println("\t\t |         THIS IS DOCTOR REGISTRATION PAGE		   |");
        System.out.println("\t\t |___________________________________________________|");

        System.out.println("Please enter your name");
        doctorName.add(scan.next());
        System.out.println("please enter your mobile number");
        mobileNumber = scan.nextLong();

        long mno;

        if(doctorPhNo.isEmpty()){
            doctorPhNo.add(mobileNumber);
            System.out.println("please enter your password");
            doctorPasssword.add(scan.next());
            Thread.sleep(1000);
            flag1=false;

        }
        else{
            for(i=0;i<=doctorPhNo.size()-1;i++){
                mno = doctorPhNo.get(i);
                if(mno==mobileNumber){
                    flag1=false;
                    break;
                }
            }
            if(flag1==true){
                doctorPhNo.add(mobileNumber);
                System.out.println("enter age");
                doctorAge.add(scan.nextInt());
                System.out.println("enter the city");
                doctorCity.add(scan.next());
                System.out.println("enter password");
                doctorPasssword.add(scan.next());
                System.out.println("Registration is successfull");

                System.out.println("Details : Name : "+doctorName + " \n number : " + doctorPhNo);
                Thread.sleep(1000);
            }
            else{
                System.out.println("same mobile number is  not allowed\n");
                int index = doctorName.size()-1;
                doctorName.remove(index);
                Thread.sleep(500);
            }
        }


    }

	public static void main(String[] args) throws Exception {
		AppointmentBooking ap = new AppointmentBooking();
		Scanner sc = new Scanner(System.in);
		ap.dataAdd();
		boolean flag = true;
		while (flag == true) {

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			System.out.println("---------------------------------------------------------------------");
			System.out.println("\t\t | Welcome to Doctor AppointmentBooking |");
			System.out.println("----------------------------------------------------------------------\n\n");
			System.out.println("\n1. Doctor \t 2. Patient \t 3. Admin \t 4. Exit");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					ap.doctor();
					flag = true;
					break;
				case 2:
					ap.patient();
					flag = true;
					break;
				case 3:

					ap.admin();
					flag = true;
					// Thread.sleep(1000);
					break;
				default:
					System.exit(0);

			}
		}
	}
}
