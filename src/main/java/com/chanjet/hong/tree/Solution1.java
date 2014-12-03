package com.chanjet.hong.tree;


import java.util.*;


/**
 * tree reverse
 */


public class Solution1
{
    public static void main( String[] args )
    {
        Solution1 sl = new Solution1();
    /*    TreeNode  root = TreeUtil.buildTree("1,2,3,#,4,#,6"); //"1,2,3,#,#,4,#,#,5"
        List<List<Integer>> levelDataList = sl.levelOrder(root);
        for(List<Integer> level : levelDataList){
            System.out.println(level);
        }
        boolean flag  = sl.isSymmetric(root);
        System.out.println(flag);*/

        int [] inorder = {2,1};
        int [] postorder = {2,1};
        TreeNode root = TreeUtil.buildTree2(inorder,postorder);

        List<Integer> valueList = sl.midorderTraversal(root);
        System.out.println(valueList);
    }
    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelDataList = new LinkedList<List<Integer>>();
        Queue<TreeNode> levelNodeQueue = new LinkedList<TreeNode>();
        List<Integer> levelData = new LinkedList<Integer>();
        int levelCount =0;
        if(root!=null){
            levelNodeQueue.offer(root);
            levelData.add(root.val);
            levelDataList.add(levelData);
            levelCount = 1;
        }
        levelData = new LinkedList<Integer>();
        while(!levelNodeQueue.isEmpty()){
            TreeNode curNode = levelNodeQueue.poll();
            levelCount--;

            if(curNode.left!=null){
                levelData.add(curNode.left.val);
                levelNodeQueue.offer(curNode.left);
            }
            if(curNode.right!=null){
                levelData.add(curNode.right.val);
                levelNodeQueue.offer(curNode.right);
            }
            //what contitions?
            if(levelCount ==0 && !levelNodeQueue.isEmpty()){
                levelDataList.add(levelData);
                levelCount = levelData.size();
                levelData = new LinkedList<Integer>();
            }
        }
        return levelDataList;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelDataList = new LinkedList<List<Integer>>();
        Queue<TreeNode> levelNodeQueue = new LinkedList<TreeNode>();
        List<Integer> levelData = new LinkedList<Integer>();
        int levelCount =0;
        if(root!=null){
            levelNodeQueue.offer(root);
            levelData.add(root.val);
            levelDataList.add(levelData);
            levelCount = 1;
        }
        levelData = new LinkedList<Integer>();
        while(!levelNodeQueue.isEmpty()){
            TreeNode curNode = levelNodeQueue.poll();
            levelCount--;

            if(curNode.left!=null){
                levelData.add(curNode.left.val);
                levelNodeQueue.offer(curNode.left);
            }
            if(curNode.right!=null){
                levelData.add(curNode.right.val);
                levelNodeQueue.offer(curNode.right);
            }
            //what contitions?
            if(levelCount ==0 && !levelNodeQueue.isEmpty()){
                levelDataList.add(levelData);
                levelCount = levelData.size();
                levelData = new LinkedList<Integer>();
            }
        }
        Collections.reverse(levelDataList);
        return levelDataList;
    }


    /**
     * Symmetric Tree
     *
     * 解题思路是:得出树的每一层数据,看数据是否对称即可
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> levelNodeQueue = new LinkedList<TreeNode>();
        ArrayList<TreeNode> levelData = new ArrayList<TreeNode>();

        int levelCount =1;
        if(root!=null){
            levelNodeQueue.offer(root);
        }
        while(!levelNodeQueue.isEmpty()){
            TreeNode curNode = levelNodeQueue.poll();
            levelCount--;

            if(curNode.left!=null){
                levelData.add(curNode.left);
                levelNodeQueue.offer(curNode.left);
            }else{
                levelData.add(null);
            }
            if(curNode.right!=null){
                levelData.add(curNode.right);
                levelNodeQueue.offer(curNode.right);
            }else{
                levelData.add(null);
            }
            if(levelCount ==0 && !levelNodeQueue.isEmpty()){
                for(int i=0;i<levelData.size()/2;i++){
                    TreeNode head = levelData.get(i);
                    TreeNode tail = levelData.get(levelData.size()-i-1);
                    if( head ==null && tail ==null)
                        continue;
                    if( head !=null && tail !=null && head.val == tail.val)
                        continue;
                    return false;

                }
                /*count number not null node */
                for(int i=0;i< levelData.size();i++)
                    if(levelData.get(i) != null)
                        levelCount++;
                levelData.clear();
            }
        }
        return true;
    }

    /**
     * 判断树的结构和值是否相同
     * 思路1:递归思想
     * 思路2:遍历
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null)
            return true;
        if(p!=null && q!=null && p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right))
            return true;
        else
            return false;
    }

    /**
     * 先序遍历。也得做两种方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeValueList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while( null!=curNode || !nodeStack.empty()){
            while(null!=curNode){
                nodeValueList.add(curNode.val);
                nodeStack.push(curNode);
                curNode = curNode.left;
            }
            curNode = nodeStack.pop();
            curNode = curNode.right;
        }
        return nodeValueList;
    }

    /**
     * 后续遍历。两种方法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeValueList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode curNode = root;
        TreeNode hasVisited = null;  //用来标记当前节点的右子树是否访问过
        while( null != curNode || !nodeStack.empty()){
            while(null != curNode){
                nodeStack.push(curNode);
                curNode = curNode.left;
            }
            curNode = nodeStack.peek();
            if(null == curNode.right || curNode.right == hasVisited  ){
                nodeValueList.add(curNode.val);
                hasVisited = curNode;
                nodeStack.pop();
                curNode = null;   //这个不能省,出栈就不访问左子树
            }else{
                curNode = curNode.right;
            }
        }
        return nodeValueList;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> midorderTraversal(TreeNode root){
        List<Integer> nodeValueList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode curNode = root;

        while( null != curNode || !nodeStack.empty()){
            while(null != curNode){
                nodeStack.push(curNode);
                curNode = curNode.left;
            }
            curNode = nodeStack.pop();
            nodeValueList.add(curNode.val);
            curNode = curNode.right;
        }
        return nodeValueList;
    }


    /*
        递归的方式
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> nodeValueList = new ArrayList<Integer>();
        postorderTraversalTree(root,nodeValueList);
        return nodeValueList;
    }

    public void postorderTraversalTree(TreeNode node, List<Integer> valueList){
        if(node == null)
            return;
        postorderTraversalTree(node.left,valueList);
        postorderTraversalTree(node.right,valueList);
        valueList.add(node.val);
    }






}
