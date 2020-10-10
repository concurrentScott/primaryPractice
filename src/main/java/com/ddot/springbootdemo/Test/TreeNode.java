package com.ddot.springbootdemo.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode {
    private String label;
    private String value;
    private List<TreeNode> children;

    @Override
    public String toString() {
        return "TreeNode{" +
                "label='" + label + '\'' +
                ", childs=" + children +
                ", value='" + value + '\'' +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {

        String data1 = "[{\"label\": \"下拉1\",\"value\": \"1\",\"children\": [{\"label\": \"下拉11\",\"value\": \"1-1\",\"children\": [{\"label\": \"下拉111\",\"value\":\"1-1-1\"}]}]},{\"label\": \"下拉2\",\"value\": \"2\",\"children\": [{\"label\": \"下拉21\",\"value\": \"2-1\",\"children\": [{\"label\": \"下拉211\",\"value\":\"2-1-1\"}]},{\"label\": \"下拉22\",\"value\": \"2-2\",\"children\": [{\"label\": \"下拉211\",\"value\":\"2-2-1\"}]}]}]";
        String data = "[{\"label\": \"下拉1\",\"children\": [{\"label\": \"下拉11\",\"children\": [{\"label\": \"下拉111\"}]}]},{\"label\": \"下拉2\",\"children\": [{\"label\": \"下拉21\",\"children\": [{\"label\": \"下拉211\"}]},{\"label\": \"下拉22\",\"children\": [{\"label\": \"下拉211\"}]}]}]";

        ObjectMapper objectMapper = JsonNodeUtils.getMapper();
        JavaType jt                     = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, TreeNode.class);
        ArrayList<TreeNode> nodeList = objectMapper.readValue(data, jt);

        //List<TreeNode> nodeList = JsonNodeUtils.parseToTargetObject(data,List.class);

        System.out.println(nodeList);

        TreeNode node = new TreeNode();

        //nodeList.get(1).setValue("2");

        nodeList.forEach(node1 -> {
            node1.setValue(String.valueOf(nodeList.indexOf(node1) + 1));
            node1.setIdValue(node1);
        });

        //node.setIdValue(nodeList.get(1));

       // System.out.println(nodeList.get(1));
        System.out.println(JsonNodeUtils.writeObjectToNode(nodeList));


    }

    /*public void setIdValue(TreeNode parent){
        List<TreeNode> children = parent.getChildren();
        if (!CollectionUtils.isEmpty(children)){
            for (int i = 0; i < children.size(); i++) {
                children.get(i).setValue(parent.getValue() + "-" + (i + 1));
                setIdValue(children.get(i));
            }
        }
    }*/

    public void setIdValue(TreeNode parent){
        List<TreeNode> children = parent.getChildren();
        if (!CollectionUtils.isEmpty(children)){
            children.forEach(node ->{
                    node.setValue(parent.getValue() + "-" + (children.indexOf(node) + 1));
                    setIdValue(node);
            });
        }
    }





}
