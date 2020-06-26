package test;
import java.util.*;
public class Codec {
    public String addserialize(TreeNode root,String str){
        if(root == null){
            str+="None,";
        }else{
            str += String.valueOf(root.val)+",";
            str = addserialize(root.left,str);
            str = addserialize(root.left,str);
        }
        return str;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return addserialize(root,"");
    }
   public TreeNode hahaha(List<String> list){
       if(list.get(0).equals("None")){
           list.remove(0);
           return null;
       }
       TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
       list.remove(0);
       root.left = hahaha(list);
       root.right = hahaha(list);
       return root;
   }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return hahaha(data_list);
    }
    public static void main(String[] args) {
    	String root = "1,2,3,null,null,4,5";
    	Codec codec = new Codec();
    	String aaa;
    	aaa = codec.serialize(codec.deserialize(root));
    	System.out.println(aaa);
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
		}
}


