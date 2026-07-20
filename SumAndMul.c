#include <stdio.h>

int main() {
    int A[2][2] = {{1, 2}, {3, 4}};
    int B[2][2] = {{5, 6}, {7, 8}};
    int sum[2][2], mul[2][2];
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
            sum[i][j] = A[i][j] + B[i][j];
        }
    }
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
            mul[i][j] = 0;
            for(int k=0; k<2; k++) {
                mul[i][j] += A[i][k] * B[k][j];
            }
        }
    }
    printf("Sum of matrices:\n");
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
            printf("%d ", sum[i][j]);
        }
        printf("\n");
    }

    printf("Multiplication of matrices:\n");
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
            printf("%d ", mul[i][j]);
        }
        printf("\n");
    }
    return 0;
}
