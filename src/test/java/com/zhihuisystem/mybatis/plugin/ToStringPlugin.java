package com.zhihuisystem.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.Iterator;
import java.util.List;

public class ToStringPlugin extends PluginAdapter {
	public ToStringPlugin() {
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return true;
	}

	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return true;
	}

	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return true;
	}

	private void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.setName("toString");
		if (introspectedTable.isJava5Targeted())
			method.addAnnotation("@Override");
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		method.addBodyLine("StringBuilder sb = new StringBuilder();");
		method.addBodyLine("sb.append(getClass().getSimpleName());");
		method.addBodyLine("sb.append(\" [\");");
		method.addBodyLine("sb.append(\"Hash = \").append(hashCode());");
		StringBuilder sb = new StringBuilder();
		for (Iterator<Field> i$ = topLevelClass.getFields().iterator(); i$.hasNext(); method.addBodyLine(sb.toString()))
		{
			Field field = (Field) i$.next();
			String property = field.getName();
			sb.setLength(0);
			sb.append("sb.append(\"").append(", ").append(property).append("=\")").append(".append(").append(property).append(");");
		}

		method.addBodyLine("sb.append(\"]\");");
		method.addBodyLine("return sb.toString();");
		topLevelClass.addMethod(method);
	}
}
