// Noah Cardoso
// An experment into Chat GPT
// I used varius examples online as well as help from Chat GPT to write this code
import java.util.Random;

public class PerlinNoise {

    private final int[] permutation;
    private final double persistence;
    private final int octaves;

    public PerlinNoise(long seed, int octaves, double persistence) {
	this.octaves = octaves;
	this.persistence = persistence;

	permutation = new int[256];
	Random rand = new Random(seed);
	for (int i = 0; i < 256; i++) {
	    permutation[i] = rand.nextInt(256);
	}
    }

    public double getNoise(double x, double y) {
	double total = 0;
	double frequency = 1;
	double amplitude = 1;
	double maxAmplitude = 0;

	for (int i = 0; i < octaves; i++) {
	    total += interpolateNoise(x * frequency, y * frequency) * amplitude;
	    maxAmplitude += amplitude;
	    amplitude *= persistence;
	    frequency *= 2;
	}

	return total / maxAmplitude;
    }

    private double interpolateNoise(double x, double y) {
	int x0 = (int) Math.floor(x);
	int x1 = x0 + 1;
	int y0 = (int) Math.floor(y);
	int y1 = y0 + 1;

	double tx = x - x0;
	double ty = y - y0;

	double n0, n1, ix0, ix1, value;

	n0 = dotGridGradient(x0, y0, x, y);
	n1 = dotGridGradient(x1, y0, x, y);
	ix0 = interpolate(n0, n1, tx);

	n0 = dotGridGradient(x0, y1, x, y);
	n1 = dotGridGradient(x1, y1, x, y);
	ix1 = interpolate(n0, n1, tx);

	value = interpolate(ix0, ix1, ty);
	return value;
    }

    private double dotGridGradient(int ix, int iy, double x, double y) {
	double dx = x - (double) ix;
	double dy = y - (double) iy;

	int index = permutation[(ix + permutation[iy & 255]) & 255];

	double[] gradient = gradients2D[index % gradients2D.length];
	double dot = (dx * gradient[0]) + (dy * gradient[1]);

	return dot;
    }

    private double interpolate(double a, double b, double x) {
	double ft = x * Math.PI;
	double f = (1 - Math.cos(ft)) * 0.5;
	return a * (1 - f) + b * f;
    }

    private static final double[][] gradients2D = {
	    {0, 1}, {1, 0}, {-1, 0}, {0, -1},
	    {0.707106781, 0.707106781}, {0.707106781, -0.707106781},
	    {-0.707106781, 0.707106781}, {-0.707106781, -0.707106781}
    };
}
