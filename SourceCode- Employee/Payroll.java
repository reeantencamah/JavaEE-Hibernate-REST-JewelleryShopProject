package ewel;

import java.util.Arrays;
import java.util.Date;

public class Payroll {

	int h=8;
	String position="di",jobtype="ft";
	String[] addbonus;
	double sub,vat,total=0;
	private Date date1;
	
	public String Calculate() {
		
		sub=0;
		if(position.equals("di"))
			sub+=2000;
		else if (position.equals("ma"))
			sub+=1300;
		else if (position.equals("eng"))
			sub+=900;
		else if (position.equals("tec"))
			sub+=600;
		
		if(jobtype.equals("ft"))
			sub+=100;
		else if (jobtype.equals("pt"))
			sub+=50;
		
		 sub=sub*h;
		 
		 if(Arrays.toString(addbonus).contains("over"))
			sub+=500;
		 if(Arrays.toString(addbonus).contains("bonus"))
				sub+=500;
		 
			
		vat=0.05*sub;
		total=sub-vat;
		
		return"success";
		
		
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String[] getAddbonus() {
		return addbonus;
	}

	public void setAddbonus(String[] addbonus) {
		this.addbonus = addbonus;
	}

	public double getSub() {
		return sub;
	}

	public void setSub(double sub) {
		this.sub = sub;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
		
}
