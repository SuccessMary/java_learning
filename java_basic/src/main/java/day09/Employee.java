package day09;

public abstract class Employee {

    public Employee(){

    }

    int id;
    String name;
    double salary;

    public abstract void work();
}

class CommonEmployee extends Employee{

    public void setCommonEmployeeInfo(int id, String name, double salary){
        super.id = id;
        super.name = name;
        super.salary = salary;
    }

    public void getCommonEmployeeInfo(){
        System.out.println(super.id);
        System.out.println(super.name);
        System.out.println(super.salary);
    }

    @Override
    public void work() {
        System.out.println("这是一个普通员工");
    }
}

class Manager extends Employee{

    double bonus;
    public void setManagerInfo(int id, String name, double salary,double bonus){
        super.id = id;
        super.name = name;
        super.salary = salary;
        this.bonus = bonus; //自己的属性，用this，上面的都是继承来的，用super
    }

    public void getCommonEmployeeInfo(){
        System.out.println(super.id);
        System.out.println(super.name);
        System.out.println(super.salary);
        System.out.println(this.bonus);
    }

    @Override
    public void work() {
        System.out.println("这是领导");
    }
}
