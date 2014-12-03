/* 
 * Copyright 畅捷通股份有限公司  @ 2014 版权所有    
 */
package com.chanjet.hong.tree;

/**
 * <p>
 * Balanced Binary Tree
 * </p>
 *
 * @author 洪光华 </br>
 * @Email honggh@chanjet.com
 * @date 2014年10月30日 下午8:02
 */
public class Solution2 {

    public static void main(String[] args){
        Solution2 s2 = new Solution2();
        TreeNode  root = TreeUtil.buildTree("1,2,3"); //"1,2,3,#,#,4,#,#,5"
        boolean flag = s2.isBalanced(root);
        System.out.println(flag);
    }

    /**
     * 测试是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        if(Math.abs(leftDepth-rightDepth) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 求树节点的深度
     * @param node
     * @return
     */
    public int treeDepth(TreeNode node){
        if(node ==null)
            return 0;
        int leftDepth = 1 + treeDepth(node.left);
        int rightDepth = 1 + treeDepth(node.right);
        return Math.max(leftDepth,rightDepth);
    }


}
