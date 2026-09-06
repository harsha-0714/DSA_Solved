class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_col = image[sr][sc]
        if original_col == color:
            return image
        rows , cols = len(image) , len(image[0])
        def dfs(row : int,col : int):
            if row<0 or row>=rows or col < 0 or col >= cols or image[row][col] != original_col: 
                return
            
            image[row][col] = color
            dfs(row-1,col)
            dfs(row+1,col )
            dfs(row,col-1)
            dfs(row,col+1)
        dfs(sr,sc)
        return image
        