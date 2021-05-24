import java.io.*;
import java.util.*;

class Check{
	//Defined the rules as strings as given in the problem statement.
	 String Rule1="subject verb article adjective predicate.";
	 String Rule2="subject verb article predicate.";
	 String Rule3="Verb subject article adjective predicate?";
	 String Rule4="Verb subject article predicate?";
	 public String findrule(String tocheck) {//returns a string.
		 //By using compareTo() we compare two strings lexicographically.If both are equal returns 0.
		 int aa=tocheck.compareTo(Rule1);
		 int bb=tocheck.compareTo(Rule2);
		 int cc=tocheck.compareTo(Rule3);
		 int dd=tocheck.compareTo(Rule4);
		 if(aa==0) {
			 return "(Valid. Supports Rule1)";
		 }
		 else if(bb==0) {
			 return "(Valid. Supports Rule2)";
		 }
		 else if(cc==0) {
			 return "(Valid. Supports Rule3)";
		 }
		 else if(dd==0) {
			 return "(Valid. Supports Rule4)";
		 }
		 return "(Invalid)";
	 }
}

public class Challenge {

	public static void main(String[] args) throws FileNotFoundException {
		// throws the FileNotFoundException if file is not presnt in the specified location.
		//created string arrays to store the subject,verb,adjective,predicate and articles presnt in the
		 //file tokens.txt each with size of 100(even if more token added it can take upto 100).
		 String subject[]=new String[100];
		 String verb[]=new String[100];
		 String predicate[]=new String[100];
		 String adjective[]=new String[100];
		 String article[]=new String[100];
		 String finalck[]=new String[100];
		 String verbc[]=new String[100];
		 String lines[]=new String[100];
		 int a=0,b=0,c=0,d=0,e=0;
		 int ff=0,ll=0;
		try {
			 File file = new File("C:\\Users\\shanm\\Desktop\\code\\tokens.txt");
			 Scanner sc = new Scanner(file); 
			 
			 //reading the file line by line and splitting it by using ":" as a separator and 
			 //adds the 2nd value.i.e., the element present at the first index to its array respectively.
			while (sc.hasNextLine()) {
				String arr[]=sc.nextLine().split(":");
				if(arr[0].equalsIgnoreCase("subject")) {
					subject[a]=arr[1];
					a++;
				}
				else if(arr[0].equalsIgnoreCase("verb")) {
					verb[b]=arr[1];
					b++;
				}
				else if(arr[0].equalsIgnoreCase("predicate")) {
					predicate[c]=arr[1];
					c++;
				}
				else if(arr[0].equalsIgnoreCase("adjective")) {
					adjective[d]=arr[1];
					d++;
				}
				else {
					article[e]=arr[1];
					e++;
				}
				
				  }
			//special case if verb comes at the start of a sentence its first letter is capitalized.
			for(int i=0;i<verb.length;i++) {
				if(verb[i]==null) {
					continue;
				}
				else {
					String pp=verb[i];
					verbc[i]=pp.substring(0,1).toUpperCase() + pp.substring(1).toLowerCase();
				}
			}
			sc.close();
		}
		catch(FileNotFoundException fs) {
			System.out.println("File Not Found..Please recheck the path mentioned");
		}
		catch(Exception sme) {
			System.out.println("Some error occured..!");
		}
		try {
			File f=new File("C:\\Users\\shanm\\Desktop\\code\\input.txt");
			Scanner ss = new Scanner(f);
			//Storing each line of the file into each index of lines array.
			while(ss.hasNextLine()) {
				lines[ll]=ss.nextLine();
				ll++;
			}
			ss.close();
		}
		catch(FileNotFoundException fln) {
			System.out.println("File Not Found..Please recheck the path mentioned");
		}
		try {
			File lk=new File("C:\\Users\\shanm\\Desktop\\code\\input.txt");
			Scanner sk = new Scanner(lk);
			while(sk.hasNextLine()) {
				String tock="";
				String ck[]=sk.nextLine().split(" ");
				for(int i=0;i<ck.length;i++) {
					if(i==0) {
						
					}
					if(Arrays.asList(subject).contains(ck[i])) {
						tock=tock+"subject ";
					}
					else if(Arrays.asList(verb).contains(ck[i])) {
						tock=tock+"verb ";
					}
					else if(Arrays.asList(verbc).contains(ck[i])) {
						tock=tock+"Verb ";
					}
					else if(Arrays.asList(adjective).contains(ck[i])) {
						tock=tock+"adjective ";
					}
					else if(Arrays.asList(article).contains(ck[i])) {
						tock=tock+"article ";
					}
					else if(i==ck.length-1) {
						String lastone=ck[i];
						char last[]=lastone.toCharArray();
						if(last[last.length-1]=='.') {
							tock=tock+"predicate.";
							}
						else {
							tock=tock+"predicate?";
						}
					}
					else {
						tock=tock+"Not";
					}
					
				}
				finalck[ff]=tock;
				ff++;
			}
			sk.close();
		}
		catch(FileNotFoundException flns) {
			System.out.println("File Not Found..Please recheck the path mentioned");
		}
		
		try {
			String txt="";
	            // Create a FileWriter object
	            // to write in the file
	            FileWriter fWriter = new FileWriter("C:\\Users\\shanm\\Desktop\\FinalOutput.txt");
	            // Write into the file
				for(int i=0;i<finalck.length;i++) {
					if(finalck[i]==null ) {
						continue;
					}
					if(finalck[i].length()>0) {
						Check checks=new Check();
						String jj=finalck[i];
						//output formatting as given in the output.txt
						if(checks.findrule(jj)!="(Invalid)") {
							//Uncomment the below lines to print the values on the output console.
		//					System.out.printf("%-40s %s\n", lines[i],checks.findrule(jj));
							txt=String.format("%-39s %s\n", lines[i],checks.findrule(jj));
							fWriter.write(txt);
							
						}
						else {
							//Uncomment the below lines to print the values on the output console.
		//					System.out.println(lines[i]+"  "+checks.findrule(jj));
							txt=String.format("%s  %s\n",lines[i],checks.findrule(jj));
							fWriter.write(txt);
						}
					}
					
				}
				fWriter.close();
		}
		catch (IOException ee) {
            // Print the exception
            System.out.print("error");
        }

	}
}



