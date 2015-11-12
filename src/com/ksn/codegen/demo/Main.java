package com.ksn.codegen.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class Main {
	
	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		
		cfg.setClassForTemplateLoading(Main.class, "/com/ksn/codegen/demo");
		
		Template tmp = cfg.getTemplate("pojo.ftl");
		
		Map data = new HashMap();
		data.put("package", "com.ksn.codegen.core");
		data.put("className", "HelloWorld");
		
		List properties = new ArrayList();
		Map pro1 = new HashMap();
		pro1.put("type", "String");
		pro1.put("name", "name");
		properties.add(pro1);
		
		Map pro2 = new HashMap();
		pro2.put("type", "Integer");
		pro2.put("name", "age");
		properties.add(pro2);
		
		data.put("properties", properties);
		
		
		FileOutputStream fos = new FileOutputStream(new File("d:\\HelloWorld.java"));
		tmp.process(data, new OutputStreamWriter(fos, "utf-8"));
		
		fos.flush();
		
		fos.close();
	}
}
