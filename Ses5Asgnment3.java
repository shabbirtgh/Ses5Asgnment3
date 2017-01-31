package myPack;

import java.util.Scanner;

class Employee
{
	int empId;
	String empName;
	int total_leaves;
	double total_salary,Pf,hra;
	/*
	 Pf = 12% of basic
     hra = 50% of basic
     total_sal = basic + hra – pf
	 */
	void calculate_balance_leaves()
	{
		total_leaves=28;
	}
	boolean avail_leave(int no_of_leaves, char type_of_leave)
	{
		return true;
	}
	void calculate_salary()
	{
		
	}
}
class PermanentEmp extends Employee
{
	int paid_leave, sick_leave, casual_leave,tot;
	double basic, hra,pfa;
	void print_leave_details()
	{
		paid_leave = 18;
		sick_leave = 6;
		casual_leave= 4; 
		tot = paid_leave + sick_leave + casual_leave;
	}
	@Override void calculate_balance_leaves()
	{
		total_leaves = paid_leave + sick_leave + casual_leave;
		System.out.println("Available leave are : "+total_leaves+" out of "+tot);
	}
	@Override boolean avail_leave(int no_of_leaves, char type_of_leave)
	{
		char c = type_of_leave;
		int l = no_of_leaves;
		if(c=='s')
		{
			if(sick_leave>=l)
			{
			sick_leave = sick_leave - l;
			return true;
			}
			else 
				return false;
		}
		else if(c=='p')
		{
			if(paid_leave>=l)
			{
			paid_leave = paid_leave - l;
			return true;
			}
			else 
				return false;
		}
		else 
		{
			if(casual_leave>=l)
			{
				casual_leave = casual_leave - l;
			    return true;
			}
			else 
				return false;
		}
	}
	@Override void calculate_salary()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Basic Salary of Permanent Employee");
		int bSal = sc.nextInt();
		Pf = (0.12*bSal);
	    hra = (0.50*bSal);
	    double a = bSal - Pf;
	    total_salary = a + hra;
	    System.out.println("Total Salary of Permanent Employee is : "+total_salary);
		
	}
}

class TemporaryEmp extends Employee
{
	int paid_leave, sick_leave, casual_leave,tot;
	void print_leave_details()
	{
		paid_leave = 14;
		sick_leave = 4;
		casual_leave= 4; 
		tot = paid_leave + sick_leave + casual_leave;
	}
	@Override boolean avail_leave(int no_of_leaves, char type_of_leave)
	{
		char c = type_of_leave;
		int l = no_of_leaves;
		if(c=='s')
		{
			if(sick_leave>=l)
			{
			sick_leave = sick_leave - l;
			return true;
			}
			else 
				return false;
		}
		else if(c=='p')
		{
			if(paid_leave>=l)
			{
			paid_leave = paid_leave - l;
			return true;
			}
			else 
				return false;
		}
		else 
		{
			if(casual_leave>=l)
			{
				casual_leave = casual_leave - l;
			    return true;
			}
			else 
				return false;
		}
	}
	
	@Override void calculate_balance_leaves()
	{
		
		total_leaves = paid_leave + sick_leave + casual_leave;
		System.out.print("Available leave are : "+total_leaves+" out of "+tot);
	}
	
	@Override void calculate_salary()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Basic Salary of Temporary Employee");
		int bSal2 = sc.nextInt();
		Pf = (0.12*bSal2);
	    hra = (0.50*bSal2);
	    double b = bSal2 - Pf;
	    total_salary = b + hra;
	    System.out.println("Total Salary of Temporary Employee is : "+total_salary);
	}
}

public class Ses5Asgnment3 {

	public static void main(String[] args) 
	{
		PermanentEmp pe = new PermanentEmp();
		pe.print_leave_details();
		boolean leave_available = pe.avail_leave(4,'c');
		System.out.println("Leaves available is : "+leave_available);
		pe.calculate_balance_leaves();
		pe.calculate_salary();
		
		TemporaryEmp te = new TemporaryEmp();
		te.print_leave_details();
		boolean leave_available2 = te.avail_leave(4,'s');
		System.out.println("Leaves available is : "+leave_available2);
        te.calculate_salary();
        te.calculate_balance_leaves();
	}

}
