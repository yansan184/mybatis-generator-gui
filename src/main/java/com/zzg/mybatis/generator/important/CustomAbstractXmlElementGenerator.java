package com.zzg.mybatis.generator.important;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

import java.util.Iterator;

/**
 * @author 15734
 */
public class CustomAbstractXmlElementGenerator extends AbstractXmlElementGenerator {
//    @Override
//    public void addElements(XmlElement parentElement) {
//        XmlElement answer = new XmlElement("sql");
//        answer.addAttribute(new Attribute("id", "Base_Condition"));
//        this.context.getCommentGenerator().addComment(answer);
//        XmlElement whereElement = new XmlElement("where");
//        answer.addElement(whereElement);
//        StringBuffer sb = new StringBuffer();
//        Iterator<IntrospectedColumn> iterator =
//                ListUtilities.removeGeneratedAlwaysColumns(this.introspectedTable.getAllColumns()).iterator();
//        while (iterator.hasNext()) {
//            IntrospectedColumn introspectedColumn = (IntrospectedColumn) iterator.next();
//            XmlElement isNotNullElement = new XmlElement("if");
//            sb.setLength(0);
//            sb.append(introspectedColumn.getJavaProperty("condition."));
//            sb.append(" != null");
//            isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
//            whereElement.addElement(isNotNullElement);
//
//            sb.setLength(0);
//            sb.append("and ");
//            sb.append(MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
//            sb.append(" = ");
//            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "condition."));
//            isNotNullElement.addElement(new TextElement(sb.toString()));
//        }
//        parentElement.addElement(answer);
//
//        XmlElement include = new XmlElement("include");
//        include.addAttribute(new Attribute("refid", "Condition_Where_Clause"));
//
//
//        //selectByCondition
//        XmlElement selectionByCondition = new XmlElement("select");
//        selectionByCondition.addAttribute(new Attribute("id", "selectByCondition"));
//        selectionByCondition.addAttribute(new Attribute("resultMap", "BaseResultMap"));
//        selectionByCondition.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
//
//        //公用select
//        sb.setLength(0);
//        sb.append("select ");
//        sb.append("<include refid = \"Base_Column_List\" /> ");
//        sb.append("from ");
//        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
//
//        TextElement selectText = new TextElement(sb.toString());
//        selectionByCondition.addElement(selectText);
//        selectionByCondition.addElement(include);
//        parentElement.addElement(selectionByCondition);
//    }

    public void addElements(XmlElement parentElement) {
        // Base_Condition
        XmlElement answer = new XmlElement("sql");
        answer.addAttribute(new Attribute("id", "Base_Condition"));
        //在这里添加where条件
        XmlElement whereElement = new XmlElement("where");
        answer.addElement(whereElement);
        XmlElement xmlElement = new XmlElement("if");
        xmlElement.addAttribute(new Attribute("test", "condition != null"));
        whereElement.addElement(xmlElement);
        StringBuilder sb = new StringBuilder();
        Iterator var5 = ListUtilities.removeGeneratedAlwaysColumns(this.introspectedTable.getAllColumns()).iterator();
        while (var5.hasNext()) {
            IntrospectedColumn introspectedColumn = (IntrospectedColumn) var5.next();
            XmlElement isNotNullElement = new XmlElement("if");
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty("condition."));
            sb.append(" != null");
            isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
            xmlElement.addElement(isNotNullElement);
            sb.setLength(0);
            sb.append("and ");
            sb.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sb.append(" = ");
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "condition."));
            isNotNullElement.addElement(new TextElement(sb.toString()));
        }
        parentElement.addElement(answer);


        // 公用include
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "Base_Condition"));
        // 公用select
        sb.setLength(0);
        sb.append("select ");
        sb.append(" ");
        sb.append("<include refid=\"Base_Column_List\" /> ");
        sb.append("from ");
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        TextElement selectText = new TextElement(sb.toString());
        sb.setLength(0);
        sb.append("delete ");
        sb.append("from ");
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        TextElement deleteText = new TextElement(sb.toString());

        // deleteByCondition
        XmlElement delete = new XmlElement("delete");
        delete.addAttribute(new Attribute("id", "deleteByCondition"));
        delete.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        delete.addElement(deleteText);
        delete.addElement(include);
        parentElement.addElement(delete);

        // selectByCondition
        XmlElement find = new XmlElement("select");
        find.addAttribute(new Attribute("id", "selectByCondition"));
        find.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        find.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        find.addElement(selectText);
        find.addElement(include);
        parentElement.addElement(find);

        find = new XmlElement("select");
        find.addAttribute(new Attribute("id", "selectByConditionSingle"));
        find.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        find.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        find.addElement(selectText);
        find.addElement(include);
        parentElement.addElement(find);

        // 增加list
        XmlElement list = new XmlElement("select");
        list.addAttribute(new Attribute("id", "list"));
        list.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        list.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        list.addElement(selectText);
        list.addElement(include);
        //parentElement.addElement(list);

        // 增加pageList
        XmlElement pageList = new XmlElement("select");
        pageList.addAttribute(new Attribute("id", "pageList"));
        pageList.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        pageList.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        pageList.addElement(selectText);
        pageList.addElement(include);
        //parentElement.addElement(pageList);
    }
}