/*
 *	Lab 12 Serialization and Deserialization
 */

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Records {
    private static final String RECORD = "Records.ser";

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File fin = new File(RECORD);

        //DESERIALIZATION
        try {
            Scanner in = new Scanner(System.in);
            List<Student> record = new LinkedList<Student>();

            if (fin.length() == 0) {
                System.out.println("FILE IS EMPTY!");
            }
            else {
                fis = new FileInputStream(fin);
                ois = new ObjectInputStream(fis);

                record = (List<Student>) ois.readObject();
                display(record);
                ois.close();
            }
            int choice;
            String tempString;

            do {
                System.out.println("\t\tMenu\n\t1. Register student\n\t2. Search for a student\n\t3. Remove student from list\n\t4. Save\n\t5. Display list\n\t6. Update\n\t7. Exit");
                choice = in.nextInt();
                Student temp = new Student();
                Course cos = new Course();
                switch (choice) {
                    case 1:
                        Scanner ln = new Scanner(System.in); //using a different scanner object flushes the newline character
                        temp.setStudentNumber(ln.nextLine());
                        temp.setFirstName(ln.nextLine());
                        temp.setMiddleInitial(ln.nextLine().charAt(0));
                        temp.setLastName(ln.nextLine());
                        temp.setCourse(ln.nextLine());
                        try {
                            temp.setYearLevel(Integer.parseInt(ln.next()));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        ln = new Scanner(System.in);
                        temp.setCrushname(ln.nextLine());
                        cos.setCourseCode(ln.nextLine());
                        cos.setCourseDesc(ln.nextLine());
                        temp = new Student(temp, cos);
                        record.add(temp);

                        System.out.println("Student added!");
                        display(record);
                        break;

                    case 2:
                        in.nextLine();
                        tempString = in.nextLine();

                        for (Student l : record) {
                            if (tempString.compareTo(l.getStudentNumber()) == 0) {
                                System.out.println(l);
                            }
                        }
                        break;

                    case 3:
                        tempString = in.next();
                        int removeIndex = 0, i = 0;
                        for (Student l : record) {
                            if (tempString.compareTo(l.getStudentNumber()) == 0) {
                                removeIndex = i;
                                break;
                            }
                            i++;
                        }
                        if (i != record.size() && record.size() != 0) {
                            record.remove(removeIndex);
                        }
                        display(record);
                        break;

                    case 4:

                        fos = new FileOutputStream(fin);
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(record);
                        System.out.println("Done");
                        oos.close();
                        break;

                    case 5:
                        System.out.println("Displaying contents of the student list:");
                        display(record);
                        break;
                    case 6:
                        Scanner ln2 = new Scanner(System.in);
                        System.out.println("Enter Student Number: ");
                        tempString = ln2.nextLine();
                        for (Student l : record) {
                            if (l.getStudentNumber().compareTo(tempString) == 0) {
                                int updateChoice = 0;
                                do {
                                    System.out.println("\t\tUpdate Menu\n\t1. Change first name\n\t2. Change middle initial\n\t3. Change last name\n\t4. Change Program\n\t5. Change year level\n\t6. Crush Name\n\t" +
                                            "7. Course Code\n\t8. Course Description\n\t9. I'm finished");
                                    updateChoice = in.nextInt();
                                    switch (updateChoice) {
                                        case 1:
                                            System.out.println("Enter name: ");
                                            l.setFirstName(ln2.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("Enter initial: ");
                                            l.setMiddleInitial(ln2.nextLine().charAt(0));
                                            break;
                                        case 3:
                                            System.out.println("Enter name: ");
                                            l.setLastName(ln2.nextLine());
                                            break;
                                        case 4:
                                            System.out.println("Enter course: ");
                                            l.setCourse(ln2.nextLine());
                                            break;
                                        case 5:
                                            System.out.println("Enter year: ");
                                            l.setYearLevel(ln2.nextInt());
                                            break;
                                        case 6:
                                            System.out.println("Enter crush name: ");
                                            l.setCrushname(ln2.nextLine());
                                            break;
                                        case 7:
                                            System.out.println("Enter course code: ");
                                            cos.setCourseCode(ln2.nextLine());
                                            break;
                                        case 8:
                                            System.out.println("Enter course description: ");
                                            cos.setCourseDesc(ln2.nextLine());
                                            break;
                                        case 9:
                                            break;
                                        default:
                                            System.out.println("Invalid");
                                    }
                                    System.out.println(l);
                                } while (updateChoice != 9);
                                System.out.println("Necessary fields changed.");
                            }
                        }

                        break;
                    case 7:
                        System.out.println("Exiting..\n");
                        break;
                    default:
                        System.out.print("Invalid Choice\n");
                }
            } while (choice != 7);


        } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        } catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        }
    }

    public static void display(List<Student> l) {
        for (Student ln : l) {
            System.out.println(ln);
        }
    }
}
