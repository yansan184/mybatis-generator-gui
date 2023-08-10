package com.zzg.mybatis.generator.important;

import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.sql.Types;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 15734
 */
public class CustomJavaMapperMethodGenerator extends AbstractJavaMapperMethodGenerator {
    @Override
    public void addInterfaceElements(Interface interfaze) {
        addDelete(interfaze);
        addInterfaceFind(interfaze);
        addInterfaceSelectByConditionSingle(interfaze);


    }

    private void addDelete(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
        importedTypes.add(type);
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getIntInstance();
        method.setReturnType(returnType);
        method.setName("deleteByCondition");
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("@Param(\"");
        sb.append("condition");
        sb.append("\")");
        Parameter condition = new Parameter(type, "condition");
        condition.addAnnotation(sb.toString());
        method.addParameter(condition);
        this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
        this.addMapperAnnotations(interfaze, method);
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }

    private void addInterfaceFind(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
        importedTypes.add(type);
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
        importedTypes.add(listType);
        returnType.addTypeArgument(listType);
        method.setReturnType(returnType);
        method.setName("selectByCondition");
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("@Param(\"");
        sb.append("condition");
        sb.append("\")");
        Parameter condition = new Parameter(type, "condition");
        condition.addAnnotation(sb.toString());
        method.addParameter(condition);
        this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
        this.addMapperAnnotations(interfaze, method);
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }

    private void addInterfaceSelectByConditionSingle(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
        importedTypes.add(type);
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = introspectedTable.getRules().calculateAllFieldsClass();
        method.setReturnType(returnType);
        method.setName("selectByConditionSingle");
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("@Param(\"");
        sb.append("condition");
        sb.append("\")");
        Parameter condition = new Parameter(type, "condition");
        condition.addAnnotation(sb.toString());
        method.addParameter(condition);
        this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
        this.addMapperAnnotations(interfaze, method);
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }


    private void addInterfaceFind1(Interface interfaze) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        // 添加List的包
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        // 创建方法对象
        Method method = new Method();
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是List
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("find");
        // 设置参数类型是对象
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "record"));
        //$NON-NLS-1$
        importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("@Param(\"");
        sb.append("condition");
        sb.append("\")");
        Parameter condition = new Parameter(parameterType, "record");
        condition.addAnnotation(sb.toString());
        method.addParameter(condition);
        addMapperAnnotations(interfaze, method);
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }



    private void addMapperAnnotations(Interface interfaze, Method method) {

    }
}
