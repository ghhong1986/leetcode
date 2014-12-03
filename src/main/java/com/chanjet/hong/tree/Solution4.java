/* 
 * Copyright 畅捷通股份有限公司  @ 2014 版权所有    
 */
package com.chanjet.hong.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
  * </p>
 *
 * @author 洪光华 </br>
 * @Email honggh@chanjet.com
 * @date 2014年11月01日 上午10:46
 */

public class Solution4 {

    public static void main( String[] args )
    {

 /*       int [] inorder = {2,1};
        int [] postorder = {2,1};*/
     //   TreeNode root = TreeUtil.buildTree2(inorder,postorder);

    }


    /**
     * 1. 先序遍历,保存节点,然后在将各个节点连接起来
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while(null!= curNode|| !nodeStack.empty()){
            while(null != curNode){
                nodeStack.push(curNode);
                nodeList.add(curNode);
                curNode= curNode.left;
            }
            curNode = nodeStack.pop();
            curNode = curNode.right;
        }
        nodeList.add(null);
        for(int i =0;i <nodeList.size()-1;i++){
            nodeList.get(i).left = null;
            nodeList.get(i).right = nodeList.get(i+1);
        }
    }

    /**
     * Binary Tree Maximum Path Sum(二叉树的最大路径和)
     * Given a binary tree, find the maximum path sum.
     * The path may start and end at any node in the tree.
     * 没有思路
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root ==null)
            return  0;
        else{
            int childMax = Math.max(maxPathSum(root.left),maxPathSum(root.right));
            return  Math.max(childMax,root.val);
        }
    }
}
