//Time Complexity - O(m*n)
//Space - O(m*n)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0){
            return mat;
        }
        m = mat.length;
        n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});

                }
                else{
                    mat[i][j] = -1;
                }

        }

        
    }
    int level = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                while(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = level + 1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        level++;
    }
    return mat;
    }
}