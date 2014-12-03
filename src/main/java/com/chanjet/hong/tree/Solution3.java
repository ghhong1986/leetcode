/* 
 * Copyright 畅捷通股份有限公司  @ 2014 版权所有    
 */
package com.chanjet.hong.tree;

/**
 * <p>
 Minimum Depth of Binary Tree
 The minimum depth is the number of nodes along the shortest path from the root node down to
 the nearest leaf node.
 * </p>
 *
 * @author 洪光华 </br>
 * @Email honggh@chanjet.com
 * @date 2014年10月30日 下午8:27
 */
public class Solution3 {

    public static void main(String[] args){
        Solution3 s3 = new Solution3();
        TreeNode  root = TreeUtil.buildTree("1,2,3,4"); //"1,2,3,#,#,4,#,#,5"
        int minDepth = s3.minDepth(root);

        System.out.println(minDepth);
    }
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftMinDepth = minDepth(root.left);
        int rigthMinDepth = minDepth(root.right);
        if (root.left!=null &&  root.right != null)
            return Math.min(leftMinDepth,rigthMinDepth)+1;
        else
            return Math.max(leftMinDepth,rigthMinDepth)+1;

    }
}
