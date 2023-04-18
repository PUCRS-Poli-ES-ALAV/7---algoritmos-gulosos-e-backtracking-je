public class NQueens {
    private static int n;
    private static int[] queens; // Array para armazenar a posição das rainhas

    public static void main(String[] args) {
        n = 8; // Tamanho do tabuleiro, pode ser ajustado para o valor desejado
        queens = new int[n];

        solveNQueens(0);

    }

    private static void solveNQueens(int row) {
        if (row == n) {
            printQueens(); // Se todas as rainhas foram colocadas, imprime a solução
        } else {
            for (int col = 0; col < n; col++) {
                if (isSafe(row, col)) {
                    queens[row] = col; // Coloca uma rainha na posição atual
                    solveNQueens(row + 1); // Move para a próxima linha
                }
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        // Verifica se a posição atual é segura para colocar uma rainha

        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];

            // Verifica se há uma rainha na mesma coluna ou na mesma diagonal
            if (col == prevCol || row - prevRow == Math.abs(col - prevCol)) {
                return false;
            }
        }

        return true;
    }

    private static void printQueens() {
        // Imprime a solução

        System.out.println("Solução:");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}