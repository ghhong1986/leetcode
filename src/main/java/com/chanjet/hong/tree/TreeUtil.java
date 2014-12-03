/* 
 * Copyright 畅捷通股份有限公司  @ 2014 版权所有    
 */
package com.chanjet.hong.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * TODO 这个文件的描述
 * </p>
 *
 * @author 洪光华 </br>
 * @Email honggh@chanjet.com
 * @date 2014年10月30日 下午7:59
 */
public class TreeUtil {
    public static TreeNode buildTree(String treeStr){
        String []strNodes =treeStr.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(strNodes[0]));
        queue.offer(root);
        for (int i=1;i<strNodes.length;){
            TreeNode parent = queue.poll();
            if(!strNodes[i].equals("#")){
                parent.left = new TreeNode(Integer.valueOf(strNodes[i]));
                queue.offer(parent.left);
            }
            if(i+1<strNodes.length && !strNodes[i+1].equals("#")){
                parent.right = new TreeNode(Integer.valueOf(strNodes[i+1]));
                queue.offer(parent.right);
            }
            i += 2;
        }
        return root;
    }

    /**

     * 前序和中序重建树
     * @param inorder
     * @param preorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] preorder) {
        return null;
    }




    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * 中序和后续重建树
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        TreeNode root = buildTreeRecurive(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        return root;
    }

    private static TreeNode buildTreeRecurive(int [] inorder,int []postorder,int inLow, int inHigh ,int postLow , int postHigh){
        int i;
        TreeNode root=null;
        if(postLow<=postHigh){
            root = new TreeNode(postorder[postHigh]);
            i = inLow;
            while (inorder[i] != postorder[postHigh])
                i++;
            root.right = buildTreeRecurive(inorder,postorder,i+1,inHigh,postHigh-inHigh+i,postHigh-1);
            root.left = buildTreeRecurive(inorder,postorder,inLow,i-1,postLow,postLow+i-inLow-1);
        }
       return root;
    }

}
