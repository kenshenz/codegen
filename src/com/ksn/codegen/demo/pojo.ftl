package ${package};

import java.util.Date;

public class ${className} implements Serializable {
<#list properties as pro>
	private ${pro.type} ${pro.name};
</#list>

<#list properties as pro>
	public void set${pro.name?cap_first}(${pro.type} ${pro.name}) {
		this.${pro.name} = ${pro.name};
	}

	public ${pro.type} get${pro.name?cap_first}() {
		return this.${pro.name};
	}

</#list>
	@Override
	public String toString() {
		return "${className} [<#list properties as pro>${pro.name}=" + ${pro.name} + "<#sep>, </#list>]";
	}

}