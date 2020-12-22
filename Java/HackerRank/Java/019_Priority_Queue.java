import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int _id;
    private String _name;
    private double _cgpa;

    public Student(int id, String name, double cgpa) {
        _id = id;
        _name = name;
        _cgpa = cgpa;
    }

    public int getID() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public double getCGPA() {
        return _cgpa;
    }
    
}

class StudentComparator implements Comparator<Student>{ 
              
    public int compare(Student s1, Student s2) { 
        if (s1.getCGPA() < s2.getCGPA()) {
            return 1; 
        }
        else if (s1.getCGPA() > s2.getCGPA()) {
            return -1; 
        }
        else {
            int nameComparison = s1.getName().compareTo(s2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            }
            else {
                return (s1.getID() > s2.getID()) ? 1 : -1;
            }
        }
    } 
} 

class Priorities {
    
    public List<Student> getStudents(List<String> events) {
        int eventsSize = events.size();
        PriorityQueue<Student> studentQueue = new PriorityQueue<Student>(eventsSize, new StudentComparator());
        List<Student> studentList = new ArrayList<Student>();

        for (int i=0; i < eventsSize; i++) {
            String event = events.get(i);
            String[] eventParts = event.split(" ");
            String command = eventParts[0];

            //System.out.println("command: " + command);
            
            if (command.equals("ENTER")) {
                String name = eventParts[1];
                double cgpa = Double.parseDouble(eventParts[2]);
                int id = Integer.parseInt(eventParts[3]);

                // System.out.println("name: " + name);
                // System.out.println("cgpa: " + cgpa);
                // System.out.println("id: " + id);

                Student student = new Student(id, name, cgpa);
                studentQueue.add(student);
            }
            else {
                studentQueue.poll();
            }
        }

        while (!studentQueue.isEmpty()) {
            studentList.add(studentQueue.poll());
        }

        return studentList;         
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}