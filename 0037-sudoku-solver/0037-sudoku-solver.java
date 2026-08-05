class Solution {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];
    public void solveSudoku(char[][] board) {

        for(int i = 0;i<9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                char ch = board[i][j];
                if(ch != '.'){
                    int boxIdx = (i/3) * 3 + (j/3);
                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    box[boxIdx].add(ch);
                }
            }
        }
        backtrack(board,0,0);
    }
    public boolean backtrack(char[][] board , int r , int c){
        if(r== 9) return true;
        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c == 8) ? 0 : c+1;
        if(board[r][c] != '.'){
            return backtrack(board,nextR,nextC);
        }
        int boxIdx = (r/3) * 3 + (c/3);
        for(char i= '1';i<='9';i++){
            if(!rows[r].contains(i) && !cols[c].contains(i) && !box[boxIdx].contains(i)){
                board[r][c] = i;
                rows[r].add(i);
                cols[c].add(i);
                box[boxIdx].add(i);
                if(backtrack(board,nextR,nextC)){
                    return true;
                }
                board[r][c] = '.';
                rows[r].remove(i);
                cols[c].remove(i);
                box[boxIdx].remove(i);
            }
        }
        return false;
    }
}