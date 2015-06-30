package week03;

public class BodyMassIndex
{
	private double d_weight, d_height;

	public double calculateBMI(int weight, int height)
	{
		// BMI in lb and in
		// (weight / (height x height)) x 703
		
		d_weight = (double)weight;
		d_height = (double)height;
		
		
		return (d_weight / (d_height * d_height)) * 703;
	}

}
