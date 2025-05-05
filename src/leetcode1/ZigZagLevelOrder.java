package leetcode1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;

        ArrayDeque<TreeNode> que=new ArrayDeque<>();
        que.add(root);
        boolean leftToRight=true;

        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<size;i++){
                if(leftToRight){
                    TreeNode cur=que.pollFirst();
                    list.add(cur.val);
                    if(cur.left!=null) que.addLast(cur.left);
                    if(cur.right!=null) que.addLast(cur.right);
                }else{
                    TreeNode cur=que.pollLast();
                    list.add(cur.val);
                    if(cur.right!=null) que.addFirst(cur.right);
                    if(cur.left!=null) que.addFirst(cur.left);
                }
            }
            ans.add(list);
            leftToRight=!leftToRight;
        }
        return ans;
    }
}
