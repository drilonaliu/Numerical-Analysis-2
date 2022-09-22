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

## Expansion of a complex matrix A to a real matrix twice as big.

The number $\lambda$ is called an eiguenvalue of matrix A if  

$$Ax =\lambda\ x$$ 

$$ =>(A- \lambda I)x = 0 $$

This homogeneous system of equations has nonzero solutions if and only if the coefficient matrix $(A- \lambda I)$ is singular; that is, if and only if
the determinant of $(A- \lambda I)$ is zero.

When $\lambda$ is a complex number, we should expand the complex matrix to a real one, which is best demonstrated by the following example. Let us find the eiguen value of the matrix A.

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

Finding euiguen vector when $\lambda = 1+i\sqrt3$, we have 

$$(A- (1+i\sqrt3) I)x = 0 =>
\begin{pmatrix}
-i\sqrt3 & 0 & 2 \\
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

$$
=>
\begin{pmatrix}
0a_1 -ia\sqrt3 a_3 + \sqrt3 b_1 + 0b_1 + 0a_2 +0ia_2 + 0b_2 +0ib_2 + 2a_3+0ia_3+0b_3+2ib_3 \\
0a_1 + 0ia_1 + 0b_1 + 0ib_1 + 0a_2-i\sqrt3 a_2+\sqrt3b_2+0i(b_2) -a_3+0ia_3 +0b_3-ib_3 \\
-1a_1+0ia_1+0b_1-ib_1 +a_2+0ia_2 +0b_2+ib_2+0a_3-i\sqrt3 a_3 + \sqrt3 b_3+0ib_3 \\
\end{pmatrix} = 
\begin{pmatrix}
0 \\
0 \\
0 \\
\end{pmatrix}
$$

Which is equivalent to solving 

$$\begin{pmatrix}
0 & \sqrt3 & 0 & 0 & 2 & 0 \\
-\sqrt3 & 0 & 0& 0 & 0 & 2 \\
0 & 0 & 0 & \sqrt3 & -1 & 0 \\
0 & 0 & -\sqrt3 & 0 & 0 & -1 \\
-1 & 0 & 1 & 0 & 0 & \sqrt3 \\
0 & -1 & 0 & 1 & -\sqrt3 & 0 \\
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


The 6x6 matrix was obtained by getting the constats of each row  near $a_k,b_k$ and $ia_k, ib_k$, $\forall k \in {1,2,3}$ . So each row of a 3x3 matrix is divided into two rows, the first row with only real constants near $a_k,b_k$, and the second row with constants near $ia_k,ib_k$.

![matrixca 3](https://user-images.githubusercontent.com/84543584/191829991-9627917b-5ff6-4f71-9c39-f25acb6e59ac.png)


### Making the expanding algorithm

Let $z_{ij}=c_{ij} + id_{ij} \in A, \forall i,j \in {{1,2,3}}$
Note that 

 $z_{ij}(a_j+ib_j) = (c_{ij}+id_{ij})(a_j+ib_j) = {\color{red}c_{ij}}a_j + i{\color{blue}d_{ij}}a_j -{\color{red}d_{ij}}b_j+i{\color{blue}c_{ij}}b_j$
 
 So for the i-th row of 3x3 matrix in (1), we know now the coefficients near $a_j,b_j,ia_j,ib_j$, which are $c_{ij},-d_{ij},d_{ij},c_{ij}$, which is $Re(z),-Im(z),Im(z),Re(z)$ respectfully.
 Now based on this rule, we iterate through each element of the matrix A in (1) and fill it the 6x6 matrix with constants near $a_k,b_k$ and $ia_k, ib_k$.
  
    public Matrix expandToReal() {
          int n = rows;
          double[][] M = new double[2 * n][2 * n];
          for (int i = 0; i < CM.length; i++) {
              for (int j = 0; j < CM.length; j++) {
                  Complex Z = this.get(i, j);
                  double c_ij = Z.getReal();
                  double d_ij = Z.getImaginary();
                  M[2 * i][2 * j] = c_ij;
                  M[2 * i + 1][2 * j] = d_ij;
                  M[2 * i][2 * j + 1] = -1.0 * d_ij;
                  M[2 * i + 1][2 * j + 1] = c_ij;
              }
          }
          return new Matrix(M);
      }
   
And voila, testing the algorithm we get the same 6x6 expanded matrix we got above
 
 ![image](https://user-images.githubusercontent.com/84543584/191826023-cb1b1e1b-4873-4997-898e-b305d0e3cf76.png)

Yes, I was lazy to try and print the matrix better.
 
