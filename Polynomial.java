import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.IOException;
public class Polynomial{
	double [] coefficients;
	int [] x;

	public Polynomial(){
		coefficients= new double[0];
		x= new int[0];
	}
	public Polynomial(double[] array, int[]xarray){
		this.coefficients= new double[array.length];
		for (int count=0; count<array.length; count++){
			this.coefficients[count]= array[count];
		}
		this.x= new int[xarray.length];
		for (int counter=0; counter<xarray.length; counter++){
			this.x[counter]=xarray[counter];
		}
	}
	public Polynomial add (Polynomial p){
		// int max=coefficients.length;
		// if (p.coefficients.length>coefficients.length){
		// 	max=p.coefficients.length;
		// }
		
		Polynomial result = new Polynomial();
		int max = this.coefficients.length + p.coefficients.length;
		double[] tcoef = new double[max];
		int[] tx = new int[max];
		for (int c=0; c<this.coefficients.length;c++){
			tcoef[c]=this.coefficients[c];
			tx[c]=this.x[c];
		}
		int num = this.coefficients.length;
        
            for (int counter = 0; counter < p.coefficients.length; counter++) {
				boolean different= true;
				for (int count=0; count<this.coefficients.length; count++){
					if (x[count]==p.x[counter])
					{
						tcoef[count]+=p.coefficients[counter];
						num++;
						different= false;
					}
					
				}
				if (different==true){
					tcoef[num]=p.coefficients[counter];
					tx[num]=p.x[counter];
					num++;
				}
			int realsize = 0;
				for (int i = 0; i < num; i++) {
					if (tcoef[i] != 0 ){
						realsize++;
					} 
				}
					
			
					result.coefficients = new double[realsize];
					result.x = new int[realsize];
					int idx = 0;
					for (int i = 0; i < num; i++) {
						if (tcoef[i] != 0 ) {
							result.coefficients[idx] = tcoef[i];
							result.x[idx] = tx[i];
							idx++;

						}
					}
				
        		// double a =0;
        		// double b =0;


        // if (count < coefficients.length ) {
        //     a =coefficients[count];
        // }

        // if (count < p.coefficients.length) {
        //     b = p.coefficients[count];
        // }
        //     result[count]=a+ b;
		
	
	}
	return result;
	}

	

	
	public double evaluate (double xi){
		double add=0.0;
		for (int count=0; count<coefficients.length;count++){
			add+= coefficients[count]*Math.pow(xi, this.x[count]);
		}
		return add;
	}
	public boolean hasRoot (double x){
		return evaluate(x)==0;
	}
	public Polynomial multiply (Polynomial a){
		Polynomial end_result= new Polynomial();
		int len1= this.coefficients.length;
		int len2= a.coefficients.length;
		for (int count=0; count<len1; count++){
			Polynomial result= new Polynomial();
			result.coefficients= new double [len2];
			result.x= new int [len2];
			for( int counter=0; counter<len2; counter++)
			{
				result.coefficients[counter]=this.coefficients[count]*a.coefficients[counter];
				result.x[counter]=this.x[count]+a.x[counter];
			}
			end_result=end_result.add(result);
		}
		return end_result;




		// int max=coefficients.length;
		// if (a.coefficients.length>coefficients.length){
		// 	max=a.coefficients.length;
		// }
		// for (int count=0; count<max;count++){
		// 	for (int counter=0; counter<a.coefficients.length; counter++){
		// 		result.coefficients[count]=coefficients[count]*a.coefficients[counter];
		// 		result.x[count]=x[count]+a.x[counter];
				
		
	

	}

	public Polynomial(File f) throws IOException{
		Polynomial result= new Polynomial();
		BufferedReader input = new BufferedReader(new FileReader(f));
		String str= input.readLine();
		input.close();

		String[] split1 = str.split("(?=[+-])");
		for (int count=0; count<split1.length; count++){
			if (split1[count].charAt(0) == '+')
			{
				split1[count]=split1[count].substring(1);
			}

		}
		int[] x1= new int[split1.length];
		double[] coef= new double[split1.length];
		ArrayList<String> split2= new ArrayList<>(Arrays.asList(split1));

		for (int counter=0; counter<split2.size(); counter++){
			int ix=split2.get(counter).indexOf('x');
			if (ix!=-1){
				String coefstr=split2.get(counter).substring(0,ix);
				String xstr=split2.get(counter).substring(ix+1);
				if (coefstr.equals("")){
					coef[counter]=1.0;
				}
				else if(coefstr.equals("-")){
					coef[counter]=-1.0;
				}
				else{
					coef[counter]=Double.parseDouble(coefstr);
				}
				if (xstr.isEmpty()){
					x1[counter]=1;
				}
				else{
					x1[counter]=Integer.parseInt(xstr);
				}


			}
			else{
				x1[counter]=0;
				coef[counter]=Double.parseDouble(split2.get(counter));
			}
		}
		// for (int counter=0; counter<split2.length; counter++){
		// 	int ix=split2.get(counter).indexOf('x');
		// 	if (ix!=-1 && ix!=split2.get(counter).length){
		// 		x1[counter]=Integer.parseInt(split2.get(counter).substring(ix+1));
		// 		coef[counter]=Double.parseDouble(split2.get(counter).substring(0,ix));
		// 	}
		// 	else if (ix!=-1 && ix==split2.get(counter).length){
		// 		x1[counter]=1;
		// 		coef[counter]=0.0;
		// 	}
		// 	else{
		// 		x1[counter]=0;
		// 		coef[counter]=Double.parseDouble(split2.get(counter).substring(0));
		// 	}
		// }
		
		// for (int counter=0; counter<split1.length; counter++){
		// 	for (int c =0; c<split1[counter].length; c++){
		// 		if (split1[counter].charAt(c)=='-'){
		// 			break;
		// 		}
		// 		if (split1[counter].charAt(c)=='x'){
		// 			if (c!= split1[counter].length)
		// 			{
		// 				x1[counter]=Integer.parseInt(split1[counter].substring(c+1));
		// 				coef[counter]=Double.parseDouble(split1[counter].substring(0,c));
		// 				break;
		// 			}
		// 			else{
		// 				x1[counter]=1;
		// 				coef[counter]=0.0;
		// 				break;
		// 			}
		// 		}
		// 		else{
		// 			x1[counter]=0;
		// 			coef[counter]=Double.parseDouble(split1[counter]);
		// 		}
		// 	}

		
		
		// result.coefficients= new double [coef.length];
		// result.x= new int [x1.length];
		// for (int i=0; i<x1.length;i++){
		// 	result.coefficients[i]=coef[i];
		// 	result.x[i]=x1[i];
		// }
		this.coefficients = new double[coef.length];
		this.x = new int[x1.length];
		for (int i = 0; i < x1.length; i++) {
			this.coefficients[i] = coef[i];
			this.x[i] = x1[i];
	}


	
		

		// int stringlen= //stringlen;
		// String str=//fileoutput;
		// int num=0;
		// result.coefficients=str.split("+");

		// for ( int count=0; count<stringlen; count++){
		// 	if (str[count]=='+' || str[count]=='-'){
		// 		result.coefficients[num]=
		// 	}
		// }

		// String regex="[-//+]";
		// if (count !=0){
		// 	String full= f[count-1]
		// }
	}
	public File saveToFile(String filename) throws IOException{
		ArrayList<String> str= new ArrayList<>();
		for (int count=0; count<this.coefficients.length; count++){
			if (str.size()==0){
				if (this.coefficients[count]==1.0){
					str.add("x"+this.x[count]);
				}
				else if (this.coefficients[count]== -1.0){
					str.add("-x"+this.x[count]);
				}
				else if (this.x[count]==0){
					str.add(String.valueOf(this.coefficients[count]));
				}
				else{
					str.add(String.valueOf(this.coefficients[count])+"x"+this.x[count]);
				}
				
			}
			else{
				if (this.coefficients[count]==1.0){
					str.add("+x"+this.x[count]);
				}
				else if (this.coefficients[count]== -1.0){
					str.add("-x"+this.x[count]);
				}
				else if (this.x[count]==0 && Math.signum(this.coefficients[count])==1){
					str.add("+"+String.valueOf(this.coefficients[count]));
				}
				else if (this.x[count]==0 && Math.signum(this.coefficients[count])==-1){
					str.add(String.valueOf(this.coefficients[count]));
				}
				else if (Math.signum(this.coefficients[count])==1){
						str.add("+"+String.valueOf(this.coefficients[count])+"x"+this.x[count]);
					}
				else {
						str.add(String.valueOf(this.coefficients[count])+"x"+this.x[count]);
					}
					
				}

			
			}
		
		File file =new File(filename);
		PrintStream output=new PrintStream(file);
		for (String s:str) {
			output.print(s);
		}
		output.close();
		return file;
	}
	}


		