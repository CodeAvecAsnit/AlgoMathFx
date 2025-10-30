package Calculate;


/**
 * @author : Asnit Bakhati
 */

public class NewtonsMethod {

    public float function(float[] arr, int degree, float x) {
        float ret = 0;
        for (int i = 0; i < degree; ++i) {
            ret += (float) (arr[i] * Math.pow(x, degree - i - 1));
        }
        return ret;
    }

    public float derFunction(float[] arr, int degree, float x) {
        float ret = 0;
        for (int i = 0; i < degree - 1; ++i) {
            ret +=  (float)((degree - i - 1) * arr[i] * Math.pow(x, degree - i - 2));
        }
        return ret;
    }

    public float newtonRaphson(float[] coefficients, int degree) {
        float tol = 0.005F;
        float x = 1;
        for (int i = 0; i < 10000; ++i) {
            float fx = function(coefficients, degree, x);
            float dfx = derFunction(coefficients, degree, x);
            float x1 = x - fx / dfx;
            if (Math.abs(x1 - x) < tol) {
                return x1;
            }
            x = x1;
        }
        System.out.println(x);
  return x;
    }

    public float[] horn(float[] arr, float root, int deg) {
        float[] ver = new float[deg - 1];
        ver[0] = arr[0];
        for (int i = 1; i < deg - 1; ++i) {
            ver[i] = arr[i] + ver[i - 1] * root;
        }
        return ver;
    }
}
