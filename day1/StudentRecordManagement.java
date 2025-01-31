package com.week3.day1;
class Student {
    //attribute
    int roll_number;
    String name;
    int age;
    char grade;
    Student next;

    //constructor to initialize details
    public Student(int roll_number, String name, int age, char grade) {
        this.roll_number = roll_number;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList{
    private Student head;

    //method for add student at beginning
    public void addStudentAtBeginning(int roll_number,String name,int age,char grade){
        Student student=new Student(roll_number,name,age,grade);
        student.next=head;
        head=student;

    }

    //method for add student  at last
    public void addStudentAtEnd(int roll_number,String name,int age,char grade){
        Student student=new Student(roll_number,name,age,grade);
        Student temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=student;
        student.next=null;

    }

    //method to add student at specific index
    public void addStudentAtIndex(int position,int roll_number,String name,int age,char grade){
        if(position<=0){
            System.out.println("Wrong position");
        }
        if(position==1){
            addStudentAtBeginning(roll_number,name,age,grade);
        }
        Student student=new Student(roll_number,name,age,grade);
        Student temp=head;
        for(int i=1;i<position-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Wrong position");
        }
        student.next=temp.next;
        temp.next=student;

    }

    //method to delete student
    public void deleteStudent(int roll_number){
        if(head.roll_number==roll_number){
            head=head.next;
            System.out.println("deleted");
        }
        Student temp=head;
        while(temp.next!=null&&temp.next.roll_number!=roll_number){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("no student");
        }
        temp.next=temp.next.next;
        System.out.println("deleted");
    }

    //method to search student
    public Student searchStudent(int roll_number){
        if(head.roll_number==roll_number){
            return head;
        }
        Student temp=head;
        while(temp.next!=null&&temp.next.roll_number!=roll_number){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("no student");
        }
        return temp.next;
    }

    //method to display student
    public void displayStudent(){
        if(head==null){
            System.out.println("there are no students");
        }
        Student temp=head;
        while(temp.next!=null){
            System.out.println(" Roll Number: " + temp.roll_number + " Name: " + temp.name + " Age " + temp.age + " Grade " + temp.grade);
            temp = temp.next;
        }
    }

    //method to update student grade
    public void updateStudentGrade(int roll_number,char grade){
        if(head.roll_number==roll_number){
            head.grade = grade;
        }
        Student temp = head;
        while(temp.next!=null&&temp.next.roll_number!=roll_number){
            temp = temp.next;
        }
        if(temp.next==null){
            System.out.println("no student");
        }
        temp.next.grade = grade;
    }

}

public class StudentRecordManagement {
    public static void main(String[] args) {
        //object of class StudentList
        StudentList list = new StudentList();

        //add student
        list.addStudentAtBeginning(1,"aa",14,'A');
        list.displayStudent();
        list.addStudentAtBeginning(2,"bb",13,'B');
        list.displayStudent();
        list.addStudentAtBeginning(3,"cc",13,'A');
        list.displayStudent();
        list.addStudentAtEnd(4,"dd",14,'B');
        list.displayStudent();
        list.addStudentAtEnd(5,"ee",14,'B');
        list.displayStudent();
        list.deleteStudent(2);
        list.displayStudent();
        list.updateStudentGrade(1,'C');
        list.displayStudent();
    }
}
