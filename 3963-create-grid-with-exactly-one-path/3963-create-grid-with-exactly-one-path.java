class Solution {
    public String[] createGrid(int m, int n) {
        String[] arr = new String[m];
        char[] row =new char[n];
        for(int  i =0;i<n;i++){
            row[i] = '#';
        }
        for(int i = 0;i<m;i++){
            arr[i] = new String(row);
        }
        char[] temp = arr[0].toCharArray();
        for(int i = 0;i<n;i++){
            temp[i] = '.';
        }
        arr[0] = new String(temp);
        for(int i = 0;i<m;i++){
            char[] curr = arr[i].toCharArray();
            curr[n-1] = '.';
            arr[i] = new String(curr);
        }
        return arr;
    }
}