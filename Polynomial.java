public class Polynomial{
	double [] coefficients;

	public Polynomial(){
		coefficients= new double[0];
	}
	public Polynomial(double[] array){
		this.coefficients= new double[array.length];
		for (int count=0; count<array.length; count++){
			this.coefficients[count]= array[count];
		}
	}
	public Polynomial add (Polynomial p){
		int max=coefficients.length;
		if (p.coefficients.length>coefficients.length){
			max=p.coefficients.length;
		}
		double[] result = new double[max];

        
            for (int count = 0; count < max; count++) {
        		double a =0;
        		double b =0;

        if (count < coefficients.length) {
            a =coefficients[count];
        }

        if (count < p.coefficients.length) {
            b = p.coefficients[count];
        }
            result[count]=a+ b;
		}
		return new Polynomial(result);
	}

	
	public double evaluate (double x){
		double add=0.0;
		for (int count=0; count<coefficients.length;count++){
			add+= coefficients[count]*Math.pow(x, count);
		}
		return add;
	}
	public boolean hasRoot (double x){
		return evaluate(x)==0;
	}
}
		