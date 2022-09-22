# Numerical-Analysis-2

A package for Numerical Analysis 2 course I wrote for my class, including:

  1. Matrix and vector operations( addition, multiplication..)
  2. Models for complex numbers, complex matrix and complex vectors.
  2. Infinity norm, euclidian norm(for vectors), Frobenious norm(matrices).
  3. Matrix convergence test.
  4. Power method for finding eiugenvalues and eiguenvector of a Matrix.
  5. Expansion of a matrix A with complex numbers to a matrix twice as big with a matrix with real numbers. 
  6. Jacobi Iterative and Gauss Seidel  methods for solving system of linear equations. 


 ### Matrix convergence test 
 A $nxn$ matrix $A$ is called convergent if 
 
$\displaystyle \lim_{k \to \infty} (A^k)_{ij} = 0$ for each  $i = 1, 2, . . . , n$ and $j = 1, 2, . . . n$. The algorithm would follow 

    Input: Matrix A, n0 (max number of iterations), TOL
    Output: true or false 
    S1: set A1 = A
    S2: set k = 1
    S3: while k<=n0 do S4 - S6
    S4: set A = A*A1
    S5: if $|a_i|$ < TOL, for each  $i = 1, 2, . . . , n$ and $j = 1, 2, . . . n$, then  
        Output(The matrix A converges)
        STOP
    S6  k := k+1;
    S7 Output(Tolerance was not met within the max number of iterations).

And in java the implentation went 
  
      public boolean converges(double tol, int max) {
        Matrix M1 = new Matrix(M);
        double[][] A;
        boolean found = false;
        int k = 1;
        while (k <= max && !found) {
            M1 = M1.multiply(this);
            A = M1.getPrimitive();
            boolean converge = true;
            for (int i = 0; i < rows && converge; i++) {
                for (int j = 0; j < columns; j++) {
                    if (Math.abs(A[i][j]) > tol) {
                        converge = false;
                        break;
                    }
                }
            }
            if (converge) {
                found = true;
            }
            k = k + 1;
        }
        return found;
    }

### Expansion of a complex matrix A to a real matrix twice as big.

The number $\lambda$ is called an eiguenvalue of matrix A if  

$$Ax =\lambda\ x$$ adfas
asdfasfdasdfsdaasdfasdfa

$$ =>(A- \lambda I)x = 0 $$

This homogeneous system of equations has nonzero solutions if and only if the coefficient matrix $(A- \lambda I)$ is singular; that is, if and only if
the determinant of $(A- \lambda I)$ is zero.

When $\lambda$ is a complex number, we should expand the complex matrix to a real one, which is best demonstrated by the following example.

$$ 
A =
\begin{pmatrix}
1 & 0 & -2 \\
0 & 1 & -1 \\
-1 & 1 &1 \\
\end{pmatrix}
$$

$$det(A-\lambda I)=\lambda (1-\lambda)(\lambda^2-2\lambda+4)$$ 


$$det(A - \lambda I) = 0 => \lambda_1 = 1, \lambda_2=1+i\sqrt3, \lambda_3=1-i\sqrt3$$

Finding euiguen vector when $\lambda = 1+i\sqrt3$, we get 

$$(A- (1+i\sqrt3) I)x = 0 =>
\begin{pmatrix}
-i\sqrt(3) & 0 & 2 \\
0 & -i\sqrt3 & -1\\
-1 & 1 &-i\sqrt3 \\
\end{pmatrix}
\begin{pmatrix}
x_1 \\
x_2 \\
x_3 \\
\end{pmatrix} = 
\begin{pmatrix}
0 \\
0 \\
0 \\
\end{pmatrix}
$$

Setting $x_i=a_i+ib_i$. Solving system 

$$\begin{pmatrix}
-i\sqrt(3) & 0 & 2 \\
0 & -i\sqrt3 & -1\\
-1 & 1 &-i\sqrt3 \\
\end{pmatrix}
\begin{pmatrix}
a_1+ib_1 \\
a_2+ib_2 \\
a_3+ib_3 \\
\end{pmatrix} = 
\begin{pmatrix}
0 \\
0 \\
0 \\
\end{pmatrix}
$$



is equivalent to solving the system 


asdfasdf 
asdfasd 



$$\begin{pmatrix}
0 & \sqrt3 & 0 & 0 & 2 & 0 \\
-\sqrt3 & 0 & 0& 0 & 0 & 2 \\
0 & 0 & 0 & \sqrt3 & -1 & 0 \\
0 & 0 & -\sqrt3 & 0 & 0 & -1 \\
-1 & 0 & 1 & 0 & 0 & \sqrt3 \\
0 & -1 & 0 & 1 & 1 * -\sqrt3 & 0 \\
\end{pmatrix}
\begin{pmatrix}
a_1\\
b_1\\
a_2\\
b_2 \\
a_3 \\
b_3 \\
\end{pmatrix} = 
\begin{pmatrix}
0\\
0\\
0\\
0 \\
0 \\
0 \\
\end{pmatrix}
$$


You can use the following construction:

$$\begin{matrix}
 & \begin{matrix} a_1 &b_1  &a_2  &b_2  &a_3  &b_3  \end{matrix} \\\\
\begin{matrix}Re\\\\\Im\\\\\Re\\\\\Im\\\\\Re\\\\\Im \end{matrix} & 
  \begin{pmatrix}0 & \sqrt3 & 0 & 0 & 2 & 0\\\\-\sqrt3 & 0 & 0& 0 & 0 & 2\\\\0 & 0 & 0 & \sqrt3 & -1 & 0\\\\0 & 0 & -\sqrt3 & 0 & 0 & -1\\\\-1 & 0 & 1 & 0 & 0 & \sqrt3 \\\\-1 & 0 & 1 & 0 & 0 & \sqrt3 \\\\ 0 & -1 & 0 & 1 & 1 * -\sqrt3 & 0 \end{pmatrix}\\\\
\end{matrix}$$


asdfasdf

$$
\begin{array}{c c} &
\begin{array}{c c c c c c} a_1 &b_1  &a_2  &b_2  &a_3  &b_3  \\
\end{array}
\\
\begin{array}{c c c}
p \\
q\\
r
\end{array}
&
\left[
\begin{array}{c c c c c c}
0 & \sqrt3 & 0 & 0 & 2 & 0 \\
-\sqrt3 & 0 & 0& 0 & 0 & 2 \\
0 & 0 & 0 & \sqrt3 & -1 & 0 \\
0 & 0 & -\sqrt3 & 0 & 0 & -1 \\
-1 & 0 & 1 & 0 & 0 & \sqrt3 \\
0 & -1 & 0 & 1 & 1 * -\sqrt3 & 0 \\
\end{array}
\right]
\end{array}
$$
