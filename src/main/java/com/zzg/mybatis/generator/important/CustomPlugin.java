package com.zzg.mybatis.generator.important;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.List;

/**
 * @author 15734
 */
public class CustomPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return false;
    }

//    @Override
//    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
//        AbstractXmlElementGenerator elementGenerator = new CustomAbstractXmlElementGenerator();
//        elementGenerator.setContext(context);
//        elementGenerator.setIntrospectedTable(introspectedTable);
//        elementGenerator.addElements(document.getRootElement());
//        return super.sqlMapDocumentGenerated(document, introspectedTable);
//    }
//
//    @Override
//    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
//        AbstractJavaMapperMethodGenerator methodGenerator = new CustomJavaMapperMethodGenerator();
//        methodGenerator.setContext(context);
//        methodGenerator.setIntrospectedTable(introspectedTable);
//        methodGenerator.addInterfaceElements(interfaze);
//        return super.clientGenerated(interfaze, introspectedTable);
//
//    }
}
